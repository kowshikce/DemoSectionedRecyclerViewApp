package com.example.sectionedrecyclerview.ModelData;

public class HomeModel {
    private String userId;
    private String id;
    private String title;
    private String body;

    public HomeModel(String userId, String id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
