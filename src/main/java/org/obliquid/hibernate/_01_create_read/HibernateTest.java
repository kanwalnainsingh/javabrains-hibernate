package org.obliquid.hibernate._01_create_read;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

        private static SessionFactory sessionFactory = new Configuration().configure("postgresql.cfg.xml")
                        .buildSessionFactory();

        public static void main(String[] args) {
                HibernateTest instance = new HibernateTest();
                instance.insertUser();
                instance.loadUser();
        }

        private void loadUser() {
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                UserDetail user = (UserDetail) session.get(UserDetail.class, 1);
                System.out.println(user);
        }

        private void insertUser() {
                UserDetail user = new UserDetail();
                user.setUserName("First User");
                user.setAddress("First User's address");
                String description = "First description that is going to be very long since we would like "
                                + "to have a description that is longer than 255 characters. How can we "
                                + "do that? Should I keep on writing nonsense? Or is it enough already? "
                                + "I think it isn't yet... we have to keep on adding things and useless "
                                + "words until the limit is reached.";
                user.setDescription(description);
                user.setJoinedDate(Date.valueOf("2011-10-01"));

                Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(user);

                UserDetail user2 = new UserDetail();
                user2.setUserName("Second user");
                session.save(user2);

                session.getTransaction().commit();
                session.close();
        }

}
