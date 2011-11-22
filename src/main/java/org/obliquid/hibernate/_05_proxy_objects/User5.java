package org.obliquid.hibernate._05_proxy_objects;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.obliquid.hibernate._02_value_object.Address;

@Entity
@Table(name = "user5")
public class User5 {

        private int userId;

        private String userName;

        private Collection<Address> listOfAddresses = new ArrayList<Address>();

        /**
         * @return the userId
         */
        @Id
        @GeneratedValue
        public int getUserId() {
                return userId;
        }

        /**
         * @param userId
         *                the userId to set
         */
        public void setUserId(int userId) {
                this.userId = userId;
        }

        /**
         * @return the userName
         */
        public String getUserName() {
                return userName;
        }

        /**
         * @param userName
         *                the userName to set
         */
        public void setUserName(String userName) {
                this.userName = userName;
        }

        /**
         * FetchType can be LAZY (default) or EAGER.
         * 
         * @return the listOfAddresses
         */
        @ElementCollection(fetch = FetchType.LAZY)
        @JoinTable(name = "user5_address", joinColumns = @JoinColumn(name = "user5_id"))
        public Collection<Address> getListOfAddresses() {
                return listOfAddresses;
        }

        /**
         * @param listOfAddresses
         *                the listOfAddresses to set
         */
        public void setListOfAddresses(Collection<Address> listOfAddresses) {
                this.listOfAddresses = listOfAddresses;
        }

        @Override
        public String toString() {
                return "username: " + getUserName();
        }

}
