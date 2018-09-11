package com.example.jkwak.registeration;

public class Notice {

    String notice;
    String name;
    String date;

    public Notice(String notice, String date, String name) { // 공지 내용, 날짜, 글쓴이
        this.notice = notice;
        this.date = date;
        this.name = name;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
