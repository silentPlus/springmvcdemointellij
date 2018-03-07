package com.suvan.beancopy;

/**
 * Created by suvan on 2017/12/14.
 */
public class DesBean {
    private Integer age;
    private String title;
    private Boolean eat;
    private String self;

    private Integer convert;

    public DesBean() {
    }

    public DesBean(Integer age, String title, Boolean eat, String self) {
        this.age = age;
        this.title = title;
        this.eat = eat;
        this.self = self;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getEat() {
        return eat;
    }

    public void setEat(Boolean eat) {
        this.eat = eat;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Integer getConvert() {
        return convert;
    }

    public void setConvert(Integer convert) {
        this.convert = convert;
    }

    @Override
    public String toString() {
        return "DesBean{" +
                "age=" + age +
                ", title='" + title + '\'' +
                ", eat=" + eat +
                ", self='" + self + '\'' +
                ", convert=" + convert +
                '}';
    }
}
