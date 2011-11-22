package org.obliquid.hibernate._03_set;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.obliquid.hibernate._02_value_object.Address;

@Entity
@Table(name = "user3")
public class User3 {

        private int userId;

        private String userName;

        private Set<Address> listOfAddresses = new HashSet<Address>();

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
         * @return the listOfAddresses
         */
        @ElementCollection
        @JoinTable(name = "user3_address", joinColumns = @JoinColumn(name = "user3_id"))
        public Set<Address> getListOfAddresses() {
                return listOfAddresses;
        }

        /**
         * @param listOfAddresses
         *                the listOfAddresses to set
         */
        public void setListOfAddresses(Set<Address> listOfAddresses) {
                this.listOfAddresses = listOfAddresses;
        }

}
