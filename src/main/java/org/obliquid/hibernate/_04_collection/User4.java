package org.obliquid.hibernate._04_collection;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.obliquid.hibernate._02_value_object.Address;

@Entity
@Table(name = "user4")
public class User4 {

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
         * @return the listOfAddresses
         */
        @ElementCollection
        @JoinTable(name = "user4_address", joinColumns = @JoinColumn(name = "user4_id"))
        @GenericGenerator(name = "hilo-gen", strategy = "hilo")
        @CollectionId(columns = { @Column(name = "address_id") }, generator = "hilo-gen",
                        type = @Type(type = "long"))
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

}
