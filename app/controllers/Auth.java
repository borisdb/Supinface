package controllers;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.org.apache.bcel.internal.generic.NEW;

import play.db.jpa.Model;
import play.jobs.Every;
import play.jobs.Job;
import play.mvc.Controller;
import models.User;

public class Auth extends Controller {

    private static ConcurrentHashMap<String, LoggedUser> loggedUserMap = new ConcurrentHashMap<String, LoggedUser>();

    public static void login(String login, String password) {
        ObjectMapper mapper = new ObjectMapper();
        
        String msg = "bad login/password";
        User user = User.connect(login, password);
        if (user != null) {
            createAuth(user);
            //renderJSON(loggedUserMap);
            try {
                String usr= mapper.writeValueAsString(user);
                System.out.println(usr);
            } catch (JsonGenerationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            renderJSON(msg);
        }
    }

    /**
     * @author boris
     * 
     * @param token
     * @return
     */
    public static boolean checkAuth(String token) {
        if (loggedUserMap.containsKey(token)) {
            LoggedUser loggedUser = loggedUserMap.get(token);

            // 1800000 pour 30 min
            if (loggedUser.getDate().getTime() + 1800000 < new Date().getTime()) {
                loggedUserMap.remove(token);
                return false;
            } else {
                loggedUserMap.get(token).setDate(new Date());
                return true;
            }
        } else {
            return false;
        }
    }

    private static void createAuth(User user) {
        String token = UUID.randomUUID().toString();
        loggedUserMap.put(token, new LoggedUser(user));
    }

    @Every("1h")
    public class Routine extends Job {
        public void doJob() {
            Long date = new Date().getTime();
            for (String token : loggedUserMap.keySet()) {
                if (loggedUserMap.get(token).getDate().getTime() + 1800000 < date) {
                    loggedUserMap.remove(token);
                }
            }
        }
    }

    private static class LoggedUser {
        private User user;
        private Date date;

        public LoggedUser(User user) {
            this.user = user;
            this.date = new Date();
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

    }

}
