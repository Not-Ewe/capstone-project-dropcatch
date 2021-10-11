package org.launchcode.DropCatch.models.data;

import org.launchcode.DropCatch.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface UserRepository extends CrudRepository <User, Integer> {

    User findByUserEmail(String name);
//    User findByUserId(int userId);

}
