package com.huayu.ssm_1901.bo;

import java.io.Serializable;
import java.util.List;

public class MengerTree implements Serializable {
    private String title;
    private List children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MengerTree{" +
                "title='" + title + '\'' +
                ", children=" + children +
                '}';
    }
}
