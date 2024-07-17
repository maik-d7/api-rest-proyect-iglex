package com.d7d.model.dao;

import com.d7d.model.entity.Uso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsoDao extends CrudRepository<Uso, Integer> {

}
