package hiwotab.nifb.repositories;

import hiwotab.nifb.Model.FBPlay;
import org.springframework.data.repository.CrudRepository;

// the table name in our db will be called Book, the unique key will be of type Long
public interface FBPlayRepostory extends CrudRepository<FBPlay,Long> {

    /*Iterable<FBPlay>findAllByGenre(String genre);
    Iterable<FBPlay>findAllBySummary(String summary);
    Iterable<FBPlay>findAllByDuration(String genre);*/
}
