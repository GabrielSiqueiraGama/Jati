module Jati {
    requires javafx.controls;
    requires spring.web;
    requires spring.tx;
    requires spring.beans;
    requires jakarta.persistence;
    requires lombok;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.data.jpa;


    opens br.com.zhant.Jati;

}