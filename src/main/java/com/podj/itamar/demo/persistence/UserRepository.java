package com.podj.itamar.demo.persistence;

import com.podj.itamar.demo.domain.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);

}
