package org.carsworld.data;

import org.carsworld.models.Car;
import org.carsworld.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
