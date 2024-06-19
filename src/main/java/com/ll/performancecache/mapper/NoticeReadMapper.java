package com.ll.performancecache.mapper;

import com.ll.performancecache.dto.Notice;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NoticeReadMapper {
    List<Notice> findAll();
    List<Notice> findByPage(int startIdx);

    List<Notice> findNoticesByDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
