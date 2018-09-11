package com.example.jkwak.registeration;

public class Course {

    int courseID; // 강의 고유 번호
    String courseUniversity; // 학부 혹은 대학원
    int courseYear; // 해당 년도
    String courseTerm; // 해당 학기
    String courseArea; // 강의 영역
    String courseMajor; // 해당 학과
    String courseGrade; // 해당 학년
    String courseTitle; // 강의 제목
    int courseCredit; // 강의 학점
    int courseNumber; // 수강 번호
    int courseHour; //  시간
    String courseProfessor; // 강의 교수
    String courseTime; // 강의 시간대
    String courseRoom; // 강의실

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseUniversity() {
        return courseUniversity;
    }

    public void setCourseUniversity(String courseUniversity) {
        this.courseUniversity = courseUniversity;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseTerm() {
        return courseTerm;
    }

    public void setCourseTerm(String courseTerm) {
        this.courseTerm = courseTerm;
    }

    public String getCourseArea() {
        return courseArea;
    }

    public void setCourseArea(String courseArea) {
        this.courseArea = courseArea;
    }

    public String getCourseMajor() {
        return courseMajor;
    }

    public void setCourseMajor(String courseMajor) {
        this.courseMajor = courseMajor;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(int courseHour) {
        this.courseHour = courseHour;
    }

    public String getCourseProfessor() {
        return courseProfessor;
    }

    public void setCourseProfessor(String courseProfessor) {
        this.courseProfessor = courseProfessor;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }

    public Course(int courseID, String courseGrade, String courseTitle, int courseNumber, int courseHour, String courseRoom) {
        this.courseID = courseID;
        this.courseGrade = courseGrade;
        this.courseTitle = courseTitle;
        this.courseNumber = courseNumber;
        this.courseHour = courseHour;
        this.courseRoom = courseRoom;
    }

    public Course(int courseID, String courseGrade, String courseTitle, int courseNumber, int courseHour, String courseRoom, int courseCredit) {
        this.courseID = courseID;
        this.courseGrade = courseGrade;
        this.courseTitle = courseTitle;
        this.courseNumber = courseNumber;
        this.courseHour = courseHour;
        this.courseRoom = courseRoom;
        this.courseCredit = courseCredit;
    }

    public Course(int courseID, String courseUniversity, int courseYear, String courseTerm, String courseArea, String courseMajor, String courseGrade, String courseTitle, int courseCredit, int courseNumber, int courseHour, String courseProfessor, String courseTime, String courseRoom) {
        this.courseID = courseID;
        this.courseUniversity = courseUniversity;
        this.courseYear = courseYear;
        this.courseTerm = courseTerm;
        this.courseArea = courseArea;
        this.courseMajor = courseMajor;
        this.courseGrade = courseGrade;
        this.courseTitle = courseTitle;
        this.courseCredit = courseCredit;
        this.courseNumber = courseNumber;
        this.courseHour = courseHour;
        this.courseProfessor = courseProfessor;
        this.courseTime = courseTime;
        this.courseRoom = courseRoom;
    }
}
