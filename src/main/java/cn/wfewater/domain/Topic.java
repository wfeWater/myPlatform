package cn.wfewater.domain;

import java.util.Date;

public class Topic {
    private int id;
    private int userId;
    private Date createTime;
    private Date updateTime;
    private String title;
    private String content;
    private int tabId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tabId=" + tabId +
                '}';
    }
}
