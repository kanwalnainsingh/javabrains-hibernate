package org.obliquid.hibernate._02_value_object;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User2 {

        private int userId;

        private String userName;

        private Address homeAddress;

        private Address officeAddress;

        /**
         * @return the userId
         */
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
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
         * It's not mandatory to specify @Embedded, but nice to have.
         * 
         * @return the address
         */
        @Embedded
        @AttributeOverrides({
                        @AttributeOverride(name = "street", column = @Column(name = "home_stret")),
                        @AttributeOverride(name = "city", column = @Column(name = "home_city")),
                        @AttributeOverride(name = "state", column = @Column(name = "home_state")),
                        @AttributeOverride(name = "postCode", column = @Column(name = "home_post_code"))
        })
        public Address getHomeAddress() {
                return homeAddress;
        }

        /**
         * @param address
         *                the address to set
         */
        public void setHomeAddress(Address homeAddress) {
                this.homeAddress = homeAddress;
        }

        /**
         * @return the officeAddress
         */
        @Embedded
        public Address getOfficeAddress() {
                return officeAddress;
        }

        /**
         * @param officeAddress
         *                the officeAddress to set
         */
        public void setOfficeAddress(Address officeAddress) {
                this.officeAddress = officeAddress;
        }

}
