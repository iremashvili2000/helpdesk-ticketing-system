package com.example.helpdeskticketingsystem.service;

import com.example.helpdeskticketingsystem.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatCleanupService {
    private final ChatMessageRepository chatRepository;


    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void deleteOldMessages() {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);

        log.info("იწყება ძველი მესიჯების წაშლა... ზღვარი: {}", oneWeekAgo);

        int deletedCount = chatRepository.deleteByTimestampBefore(oneWeekAgo);

        log.info("წაიშალა {} მესიჯი.", deletedCount);
    }

}
