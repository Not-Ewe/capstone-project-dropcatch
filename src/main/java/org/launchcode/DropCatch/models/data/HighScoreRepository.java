package org.launchcode.DropCatch.models.data;

import org.launchcode.DropCatch.models.HighScores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Transactional
@Repository
public interface HighScoreRepository extends CrudRepository<HighScores, Integer> {

}
