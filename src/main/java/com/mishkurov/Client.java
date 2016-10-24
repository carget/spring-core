package com.mishkurov;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Anton_Mishkurov
 */
@Component("client")
public class Client {
    private Integer id;
    private String fullName;
    private String greeting;

    public Client(@Value("${id}") Integer id, @Value("$[name}") String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
