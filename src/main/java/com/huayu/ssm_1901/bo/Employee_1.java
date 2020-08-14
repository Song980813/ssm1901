package com.huayu.ssm_1901.bo;

import java.util.List;

public class Employee_1 {

        private Integer id;

        private String name;

        private String sex;

        private Integer age;

        private String postId;
        private List<String> positions;

        private String deptId;

        private Integer salary;

        private String identificationPhoto;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getDeptId() {
            return deptId;
        }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public void setDeptId(String deptId) {
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

        public void setIdentificationPhoto(String identificationPhoto) {
            this.identificationPhoto = identificationPhoto == null ? null : identificationPhoto.trim();
        }

    @Override
    public String toString() {
        return "Employee_1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", postId='" + postId + '\'' +
                ", positions=" + positions +
                ", deptId='" + deptId + '\'' +
                ", salary=" + salary +
                ", identificationPhoto='" + identificationPhoto + '\'' +
                '}';
    }
}
