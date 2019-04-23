package cn.wfewater.service.Impl;

import cn.wfewater.dao.TopicMapper;
import cn.wfewater.domain.Topic;
import cn.wfewater.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements ITopicService {
    @Autowired
    private TopicMapper topicDao;
    public int add(Topic topic) {
        return topicDao.add(topic);
    }

    public List<Topic> listTopicsAndUserInfo() {
        return topicDao.listTopicsAndUserInfo();
    }

    public Topic getTopicById(Integer id) {
        return topicDao.getTopicById(id);
    }
}
