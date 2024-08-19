package com.example.demo.course;

public class Course {
    private Long id;
    private String title;
    private String courseId;
    private String desc;

    public Course() {}

    public Course(Long id, String title, String courseId, String desc){
        this.id = id;
        this.title = title;
        this.courseId = courseId;
        this.desc = desc;
    }

    public Course(String title, String courseId, String desc){
        this.title = title;
        this.courseId = courseId;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


