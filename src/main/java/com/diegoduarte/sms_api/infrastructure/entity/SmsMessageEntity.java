package com.diegoduarte.sms_api.infrastructure.entity;

import com.diegoduarte.sms_api.infrastructure.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SmsMessage")
public class SmsMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "phoneNumber", length = 11, nullable = false)
    private String phoneNumber;

    @Column(name = "status")
    private StatusEnum status; // ENVIADO, RECEBIDO, ERRO DE ENVIO

    @Column(name = "sentAt")
    private LocalDateTime sentAt;
}
