package cn.wfewater.dao;

import cn.wfewater.domain.Topic;

import java.util.List;

public interface TopicMapper {

    public int add(Topic topic);

    List<Topic> listTopicsAndUserInfo();
}
