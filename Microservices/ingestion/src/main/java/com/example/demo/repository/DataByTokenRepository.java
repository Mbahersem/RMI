package com.example.demo.repository;

import com.example.demo.entity.DataByToken;
import org.springframework.data.repository.CrudRepository;

public interface DataByTokenRepository  extends CrudRepository<DataByToken, String> {
}
