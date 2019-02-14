package com.codegik.sample.repository;

import com.codegik.sample.domain.Sample;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SampleRespository extends MongoRepository<Sample, String> {
}
