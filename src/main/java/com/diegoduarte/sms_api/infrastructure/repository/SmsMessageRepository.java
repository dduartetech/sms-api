package com.diegoduarte.sms_api.infrastructure.repository;

import com.diegoduarte.sms_api.infrastructure.entity.SmsMessageEntity;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SmsMessageRepository extends JpaRepository<SmsMessageEntity, Long> {

    List<SmsMessageEntity> findByDataEventoBetweenAndStatusNotificacaoEnum (LocalDateTime dataInicial,
                                                                   LocalDateTime dataFinal,
                                                                   Snippet.Status statusEnum);
}
