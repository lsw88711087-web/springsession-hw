package com.likelion.springsession_hw.guestbook.repository;


import com.likelion.springsession_hw.guestbook.entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long>{
}
