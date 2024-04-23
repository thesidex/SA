package fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Transactional
    public void successTransaction() {
        // Create an owner with pets
        Owner owner = new Owner("John");
        owner.setPets(Arrays.asList(new Pet("Rex"), new Pet("Whiskers")));
        ownerRepository.save(owner);

        Owner anotherOwner = new Owner("Jane");
        anotherOwner.setPets(Arrays.asList(new Pet("Buddy")));
        ownerRepository.save(anotherOwner);
    }

    @Transactional
    public void failTransaction() {
        // Create an owner with pets
        Owner owner = new Owner("John");
        owner.setPets(Arrays.asList(new Pet("Rex"), new Pet("Whiskers")));
        ownerRepository.save(owner);

        // Intentionally failing operation to trigger a rollback
        if (true) {
            throw new RuntimeException("Forced failure to test rollback");
        }

        // This line will not execute due to the exception above
        Owner anotherOwner = new Owner("Jane");
        anotherOwner.setPets(Arrays.asList(new Pet("Buddy")));
        ownerRepository.save(anotherOwner);
    }

    public void noTransaction() {
        // Create an owner with pets
        Owner owner = new Owner("John");
        owner.setPets(Arrays.asList(new Pet("Rex"), new Pet("Whiskers")));
        ownerRepository.save(owner);

        Owner anotherOwner = new Owner("Jane");
        anotherOwner.setPets(Arrays.asList(new Pet("Buddy")));
        ownerRepository.save(anotherOwner);
    }
}
