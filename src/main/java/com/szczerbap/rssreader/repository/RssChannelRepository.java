package com.szczerbap.rssreader.repository;

import com.szczerbap.rssreader.model.RssChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssChannelRepository extends JpaRepository<RssChannel,Long> {

    public RssChannel getByUserId(Long id);


}
