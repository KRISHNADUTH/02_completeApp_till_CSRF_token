package com.SpringBootFinalApp.completeApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBootFinalApp.completeApp.model.Notice;
import com.SpringBootFinalApp.completeApp.repository.NoticeRepository;

@Service
public class NoticeService {

    NoticeRepository noticeRepository;
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }
    public List<Notice> getActiveNotices() {
        return noticeRepository.findActiveNotices();
    }


}
