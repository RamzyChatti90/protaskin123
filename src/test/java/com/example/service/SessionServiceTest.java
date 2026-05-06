package com.example.service;

import com.example.domain.Session;
import com.example.repository.SessionRepository;
import com.example.service.dto.SessionDTO;
import com.example.service.mapper.SessionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SessionService {

    private static final Logger LOG = LoggerFactory.getLogger(SessionService.class);

    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    public SessionService(SessionRepository sessionRepository, SessionMapper sessionMapper) {
        this.sessionRepository = sessionRepository;
        this.sessionMapper = sessionMapper;
    }

    public SessionDTO save(SessionDTO sessionDTO) {
        LOG.debug("Request to save Session : {}", sessionDTO);
        Session session = sessionMapper.toEntity(sessionDTO);
        session = sessionRepository.save(session);
        return sessionMapper.toDto(session);
    }

    @Transactional(readOnly = true)
    public List<SessionDTO> findAll() {
        LOG.debug("Request to get all Sessions");
        return sessionRepository.findAll().stream()
            .map(sessionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Transactional(readOnly = true)
    public Optional<SessionDTO> findOne(Long id) {
        LOG.debug("Request to get Session : {}", id);
        return sessionRepository.findById(id).map(sessionMapper::toDto);
    }

    public void delete(Long id) {
        LOG.debug("Request to delete Session : {}", id);
        sessionRepository.deleteById(id);
    }
}