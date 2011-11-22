package org.obliquid.hibernate._02_value_object;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

        private String street;

        private String city;

        private String state;

        private String postCode;

        /**
         * @return the street
         */
        @Column(name = "street_name")
        public String getStreet() {
                return street;
        }

        /**
         * @param street
         *                the street to set
         */
        public void setStreet(String street) {
                this.street = street;
        }

        /**
         * @return the city
         */
        public String getCity() {
                return city;
        }

        /**
         * @param city
         *                the city to set
         */
        public void setCity(String city) {
                this.city = city;
        }

        /**
         * @return the state
         */
        public String getState() {
                return state;
        }

        /**
         * @param state
         *                the state to set
         */
        public void setState(String state) {
                this.state = state;
        }

        /**
         * @return the postCode
         */
        public String getPostCode() {
                return postCode;
        }

        /**
         * @param postCode
         *                the postCode to set
         */
        public void setPostCode(String postCode) {
                this.postCode = postCode;
        }

        @Override
        public String toString() {
                return "city: " + getCity();
        }

}
