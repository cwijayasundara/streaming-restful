package com.cham.springstreamingrestful.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("streamtweet")
public class Tweet {

    @PrimaryKey
    @JsonProperty("id")
    private String id;

    @Column("user")
    @JsonProperty("user")
    private String user;

    @Column("message")
    @JsonProperty("message")
    private String message;

    public Tweet(){

    }

    public Tweet(String id, String user, String message){
        this.id = id;
        this.user=user;
        this.message=message;
    }

    @Override
    public String toString() {
        return "Tweet{" + "id=" + id + ", user='" + user + '\'' + ", message=" + message + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String username) {
        this.user = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
