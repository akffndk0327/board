package com.example.board.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "board", schema = "goodgirl", catalog = "")
public class BoardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "INDEX")
    private int index;
    @Basic
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "CONTEXT")
    private String context;
    @Basic
    @Column(name = "TIME")
    @CreationTimestamp
    private Timestamp time;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardEntity that = (BoardEntity) o;
        return index == that.index && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(context, that.context) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, id, title, context, time);
    }
}