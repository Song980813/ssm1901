package com.huayu.ssm_1901.pojo;

public class Employee {
    private Integer id;

    private Integer usernumber;

    private String password;

    private String name;

    private String sex;

    private Integer age;

    private String postId;

    private Integer deptId;

    private Integer salary;

    private String identificationPhoto;

    private Integer mengerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(Integer usernumber) {
        this.usernumber = usernumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getIdentificationPhoto() {
        return identificationPhoto;
    }

    public Integer getMengerId() {
        return mengerId;
    }

    public void setMengerId(Integer mengerId) {
        this.mengerId = mengerId;
    }

    public void setIdentificationPhoto(String identificationPhoto) {
        this.identificationPhoto = identificationPhoto == null ? null : identificationPhoto.trim();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", postId='" + postId + '\'' +
                ", deptId=" + deptId +
                ", salary=" + salary +
                ", identificationPhoto='" + identificationPhoto + '\'' +
                '}';
    }
}