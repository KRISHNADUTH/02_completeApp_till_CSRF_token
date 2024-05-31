package com.SpringBootFinalApp.completeApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalApp.completeApp.model.Notice;
import com.SpringBootFinalApp.completeApp.service.NoticeService;

@RestController
public class NoticeController {
    
    NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notices")
    public List<Notice> getActiveNotices() {
        return noticeService.getActiveNotices();
    }

}
