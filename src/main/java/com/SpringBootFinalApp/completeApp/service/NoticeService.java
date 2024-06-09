package com.SpringBootFinalApp.completeApp.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> submitNotice(Notice notice) {
        notice.setCreateDt(Date.valueOf(LocalDate.now()));
        return new ResponseEntity<String>(noticeRepository.save(notice).toString(), HttpStatus.OK);
    }


}
