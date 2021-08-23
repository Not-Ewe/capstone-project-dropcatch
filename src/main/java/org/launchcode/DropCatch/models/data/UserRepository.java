package org.launchcode.DropCatch.models.data;

import org.launchcode.DropCatch.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {
    User findByUsername(String userEmail);
}
