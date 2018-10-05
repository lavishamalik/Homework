package com.codingblocks.planets;

public class Galaxy {
    String name,constellation,url;

    public Galaxy(String name, String constellation, String url) {
        this.name = name;
        this.constellation = constellation;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
