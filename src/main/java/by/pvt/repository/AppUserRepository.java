package by.pvt.repository;

import by.pvt.pojo.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class AppUserRepository {

    private static Logger log = Logger.getLogger("AppUserRepository");

    @Autowired
    private SessionFactory sessionFactory;

    public void save(AppUser appUser) {
        sessionFactory.getCurrentSession().save(appUser);
    }

    public AppUser findUserByEmail(String email) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from AppUser where email like :param1", AppUser.class)
                    .setParameter("param1", email)
                    .getSingleResult();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }
}
