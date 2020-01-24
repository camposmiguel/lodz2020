package com.miguelcr.customlist;

class Student {
    private String name;
    private int age;
    private String photoAddress;

    public Student(String name, int age, String photoAddress) {
        this.name = name;
        this.age = age;
        this.photoAddress = photoAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
    }
}
