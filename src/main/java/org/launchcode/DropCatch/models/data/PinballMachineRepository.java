package org.launchcode.DropCatch.models.data;

import org.launchcode.DropCatch.models.PinballMachines;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PinballMachineRepository extends CrudRepository<PinballMachines, Integer> {
    List<PinballMachines> findByMachineNameLike(String machine_name);
    List<PinballMachines> findByMachineLocationLike(String machine_location);
}
