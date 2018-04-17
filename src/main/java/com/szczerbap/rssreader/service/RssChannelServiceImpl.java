package com.szczerbap.rssreader.service;

import com.szczerbap.rssreader.model.RssChannel;
import com.szczerbap.rssreader.repository.RssChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RssChannelServiceImpl implements RssChannelService{

    @Autowired
    RssChannelRepository rssChannelRepository;

    @Override
    public void add(RssChannel rssChannel) {
        rssChannelRepository.save(rssChannel);
    }
}
