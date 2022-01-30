package com.example.pojo;

import java.util.Date;

public class Log {
    private int log_id;
    private String log_type;
    private double log_amount;
    private int userid;
    private Date log_time;
    public Log(){

    }

    public Log(String log_type, double log_amount, int userid) {
        this.log_type = log_type;
        this.log_amount = log_amount;
        this.userid = userid;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public String getLog_type() {
        return log_type;
    }

    public void setLog_type(String log_type) {
        this.log_type = log_type;
    }

    public double getLog_amount() {
        return log_amount;
    }

    public void setLog_amount(double log_amount) {
        this.log_amount = log_amount;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getLog_time() {
        return log_time;
    }

    public void setLog_time(Date log_time) {
        this.log_time = log_time;
    }
}
