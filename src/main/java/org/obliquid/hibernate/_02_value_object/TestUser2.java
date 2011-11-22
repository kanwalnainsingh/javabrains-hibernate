package org.obliquid.hibernate._02_value_object;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestUser2 {

        private static SessionFactory sessionFactory = new Configuration().configure("postgresql.cfg.xml")
                        .buildSessionFactory();

        public static void main(String[] args) {
                TestUser2 instance = new TestUser2();
                instance.insertUser();
        }

        private void insertUser() {
                User2 user = new User2();
                user.setUserName("stivlo");
                Address address = new Address();
                address.setStreet("Street Name");
                address.setCity("City Name");
                address.setPostCode("postcode");
                user.setHomeAddress(address);
                Session session = sessionFactory.getCurrentSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
        }

}
