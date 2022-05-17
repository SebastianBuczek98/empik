package com.example.s_buczek_empik.service;

import com.example.s_buczek_empik.model.RequestCountEntity;
import com.example.s_buczek_empik.repository.RequestCountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@Component
@AllArgsConstructor
public class MetricService {

    private final RequestCountRepository requestCountRepository;

    @Transactional
    public void increaseCount(String login) {
        Optional<RequestCountEntity> requestCountEntityOptional = requestCountRepository.findByLogin(login);

        if (requestCountEntityOptional.isPresent()) {
            RequestCountEntity requestCountEntity = requestCountEntityOptional.get();
            requestCountEntity.setRequest_count(requestCountEntity.getRequest_count() + 1);
            requestCountRepository.save(requestCountEntity);
        } else {
            requestCountRepository.save(new RequestCountEntity(login, 1L));
        }
    }

}
