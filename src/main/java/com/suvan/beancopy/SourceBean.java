package com.suvan.beancopy;

/**
 * Created by suvan on 2017/12/14.
 */
public class SourceBean {
    private Integer age;
    private String title;
    private String source;
    private Boolean eat;
    private String column1;
    private String column2;

    private String convert;

    private String column3;
    private String column6;
    private String column5;

    public SourceBean() {
    }

    public SourceBean(Integer age, String title, String source, Boolean eat) {
        this.age = age;
        this.title = title;
        this.source = source;
        this.eat = eat;
    }

    public SourceBean(Integer age, String title, String source, Boolean eat, String convert) {
        this.age = age;
        this.title = title;
        this.source = source;
        this.eat = eat;
        this.convert = convert;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getEat() {
        return eat;
    }

    public void setEat(Boolean eat) {
        this.eat = eat;
    }

    public String getConvert() {
        return convert;
    }

    public void setConvert(String convert) {
        this.convert = convert;
    }

    @Override
    public String toString() {
        return "SourceBean{" +
                "age=" + age +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", eat=" + eat +
                ", convert='" + convert + '\'' +
                '}';
    }

}
