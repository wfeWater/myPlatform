package cn.wfewater.dao;

import cn.wfewater.domain.Topic;

import java.util.List;

public interface TopicMapper {

    int add(Topic topic);

    List<Topic> listTopicsAndUserInfo();

    Topic getTopicById(Integer id);
}
