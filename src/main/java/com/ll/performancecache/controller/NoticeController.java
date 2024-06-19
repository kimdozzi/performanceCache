package com.ll.performancecache.controller;

import com.ll.performancecache.dto.Notice;
import com.ll.performancecache.service.NoticeService;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService){
        this.noticeService = noticeService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<Notice> notices = noticeService.getAllNotices();
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }

    @GetMapping("/{page}")
    public ResponseEntity<Object> findByPage(HttpServletRequest request, @PathVariable("page") Integer page) {
        List<Notice> notices = noticeService.findByPage(request, page);
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<Object> findNoticesByDates(@RequestParam("startDate") String startDate,
                                                     @RequestParam("endDate") String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Notice> notices = noticeService.findNoticesByDates(
                LocalDateTime.parse(startDate, formatter),
                LocalDateTime.parse(endDate, formatter)
        );
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }
}