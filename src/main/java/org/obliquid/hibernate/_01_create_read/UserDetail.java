package org.obliquid.hibernate._01_create_read;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The name property of @Table sets the table name. Use @Transient (on a getter
 * or field) to avoid persisting a field.
 * 
 * @author stivlo
 * 
 */
@Entity
@Table(name = "user_det")
public class UserDetail {

        private int userId;

        private String userName;

        private Date joinedDate;

        private String address;

        private String description;

        /**
         * The name property of @Column can be used to change the default column
         * name.
         * 
         * @return the userId
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        public int getUserId() {
                return userId;
        }

        /**
         * @return the joinedDate
         */
        @Temporal(TemporalType.DATE)
        public Date getJoinedDate() {
                return joinedDate;
        }

        /**
         * @param joinedDate
         *                the joinedDate to set
         */
        public void setJoinedDate(Date joinedDate) {
                this.joinedDate = joinedDate;
        }

        /**
         * @return the address
         */
        public String getAddress() {
                return address;
        }

        /**
         * @param address
         *                the address to set
         */
        public void setAddress(String address) {
                this.address = address;
        }

        /**
         * @return the description
         */
        @Lob
        public String getDescription() {
                return description;
        }

        /**
         * @param description
         *                the description to set
         */
        public void setDescription(String description) {
                this.description = description;
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
        @Column(name = "user_name")
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

        @Override
        public String toString() {
                return "userId=" + getUserId() + "\nuserName=" + getUserName() + "\ndescription="
                                + getDescription();
        }

}
