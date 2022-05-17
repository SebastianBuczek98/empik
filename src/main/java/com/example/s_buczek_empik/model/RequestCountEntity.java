package com.example.s_buczek_empik.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@Entity(name = "request_count")
@NoArgsConstructor
public class RequestCountEntity {

    @Id
    @Column(name = "request_count_id")
    @SequenceGenerator(name = "request_count_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_count_id_seq")
    private Long requestCountId;
    private String login;
    @Getter
    @Setter
    private Long request_count;

    public RequestCountEntity(String login, Long request_count) {
        this.login = login;
        this.request_count = request_count;
    }
}
