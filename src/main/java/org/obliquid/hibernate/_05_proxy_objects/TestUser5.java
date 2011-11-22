package org.obliquid.hibernate._05_proxy_objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.obliquid.hibernate._02_value_object.Address;

public class TestUser5 {

        private static SessionFactory sessionFactory = new Configuration().configure("postgresql.cfg.xml")
                        .buildSessionFactory();

        public static void main(String[] args) {
                TestUser5 instance = new TestUser5();
                instance.insertUser();
        }

        private void insertUser() {
                User5 user = new User5();
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

                Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
                session.close();

                user = null; //to show that we are retrieving it
                session = sessionFactory.openSession();
                //we are getting the user object without the addresses
                user = (User5) session.get(User5.class, 1);
                System.out.println(user);
                //however, in the moment I call the list method, addresses get fetched (lazy initialisation)
                System.out.println(user.getListOfAddresses());
                session.close();
        }

}
