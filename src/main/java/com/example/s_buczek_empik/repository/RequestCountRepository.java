package com.example.s_buczek_empik.repository;

import com.example.s_buczek_empik.model.RequestCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

public interface RequestCountRepository extends JpaRepository<RequestCountEntity, String> {

    Optional<RequestCountEntity> findByLogin(String login);

}
