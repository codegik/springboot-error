package com.codegik.sample.service;

import com.codegik.sample.repository.SampleRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class SampleService {
    private static final Logger log = LoggerFactory.getLogger(SampleService.class);
    private final SampleRespository sampleRespository;

    public SampleService(SampleRespository sampleRespository) {
        this.sampleRespository = sampleRespository;
    }

    @Scheduled(fixedDelay = 5000)
    public void throwDBException() {
        log.debug("finding something on database");
        sampleRespository.findAll();
    }

    @Scheduled(fixedDelay = 7000)
    public void throwIllegalArgumentException() {
        log.debug("throwing IllegalArgumentException");
        throw new IllegalArgumentException();
    }

    @Scheduled(fixedDelay = 9000)
    public void throwNullPointerException() {
        log.debug("throwing NullPointerException");
        throw new NullPointerException();
    }

    @Scheduled(fixedDelay = 11000)
    public void throwD() throws URISyntaxException {
        log.debug("requesting something");
        new RestTemplate().exchange(new URI("https://x3rfvdpl.vf/tee"), HttpMethod.GET, HttpEntity.EMPTY, Object.class);
    }

}
