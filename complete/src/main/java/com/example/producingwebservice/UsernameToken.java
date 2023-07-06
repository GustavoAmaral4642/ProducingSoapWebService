package com.example.producingwebservice;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = Security.SECURITY_NS, name = "UsernameToken")
public class UsernameToken {

    @XmlElement(name = "Username", namespace = Security.SECURITY_NS)
    private String username;

    @XmlElement(name = "Password", namespace = Security.SECURITY_NS)
    private String password;

}