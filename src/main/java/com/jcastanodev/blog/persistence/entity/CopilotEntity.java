package com.jcastanodev.blog.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "copilot_host")
public class CopilotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "copilot_id")
    private Integer id;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
