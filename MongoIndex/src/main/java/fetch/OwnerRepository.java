package fetch;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnerRepository extends MongoRepository<Owner, Integer> {
    List<Owner> findByName(String name);
}
