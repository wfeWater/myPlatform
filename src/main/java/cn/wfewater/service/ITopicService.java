package cn.wfewater.service;

import cn.wfewater.domain.Topic;

import java.util.List;

public interface ITopicService {
    int add(Topic topic);

    List<Topic> listTopicsAndUserInfo();

    Topic getTopicById(Integer id);
}
