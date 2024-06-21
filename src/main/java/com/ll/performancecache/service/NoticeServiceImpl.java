package com.ll.performancecache.service;

import com.ll.performancecache.dto.Notice;
import com.ll.performancecache.mapper.NoticeReadMapper;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeReadMapper noticeReadMapper;

    public NoticeServiceImpl(NoticeReadMapper noticeReadMapper) {
        this.noticeReadMapper = noticeReadMapper;
    }

    @Override
    // @Cacheable(value = "NoticeReadMapper.findAll")
    public List<Notice> getAllNotices() {
        return noticeReadMapper.findAll();
    }

    @Override
    // @Cacheable(value = "NoticeReadMapper.findByPage", key = "#request.requestURI + '-' + #pageNumber", condition = "#pageNumber <= 5")
    public List<Notice> findByPage(HttpServletRequest request, int pageNumber) {
        int startIdx = (pageNumber - 1) * 10;
        return noticeReadMapper.findByPage(startIdx);
    }


    @Override
    public List<Notice> findNoticesByDates(LocalDateTime startDate, LocalDateTime endDate) {
        return noticeReadMapper.findNoticesByDates(startDate, endDate);
    }
}