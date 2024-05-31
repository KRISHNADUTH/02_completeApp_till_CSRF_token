package com.SpringBootFinalApp.completeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringBootFinalApp.completeApp.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query(value = "SELECT n FROM Notice n WHERE CURRENT_DATE BETWEEN n.noticBegDt AND n.noticEndDt")
    // @Query(value = "SELECT n FROM Notice n WHERE CURDATE() BETWEEN noticBegDt AND noticEndDt")
    List<Notice> findActiveNotices();

}
