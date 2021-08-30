package org.launchcode.DropCatch.models.data;

import org.launchcode.DropCatch.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinballMachineRepository extends CrudRepository<User, Integer> {
}
