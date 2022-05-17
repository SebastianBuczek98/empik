package com.example.s_buczek_empik.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@Data
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
