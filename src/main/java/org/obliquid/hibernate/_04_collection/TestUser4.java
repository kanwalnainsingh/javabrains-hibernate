package org.obliquid.hibernate._04_collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.obliquid.hibernate._02_value_object.Address;

public class TestUser4 {

        private static SessionFactory sessionFactory = new Configuration().configure("postgresql.cfg.xml")
                        .buildSessionFactory();

        public static void main(String[] args) {
                TestUser4 instance = new TestUser4();
                instance.insertUser();
        }

        private void insertUser() {
                User4 user = new User4();
                user.setUserName("stivlo");

                Address addr1 = new Address();
                addr1.setStreet("Street Name");
                addr1.setCity("City Name");
                addr1.setPostCode("postcode");

                Address addr2 = new Address();
                addr2.setStreet("Street Name 2");
                addr2.setCity("City Name 2");
                addr2.setPostCode("postcode 2");

                user.getListOfAddresses().add(addr1);
                user.getListOfAddresses().add(addr2);

                Session session = sessionFactory.getCurrentSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
        }

}
