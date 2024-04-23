package fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// start the stopwatch
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		//fill database by reference
		for (int x = 0; x < 10000; x++) {
            // Create and save the owner
            Owner owner = new Owner("Frank" + x);
            ownerRepository.save(owner);

            // Create and save pets referencing the owner
            for (int y = 0; y < 10; y++) {
                Pet pet = new Pet("Garfield" + x + "-" + y, "Cat", owner.getName());
                petRepository.save(pet);
            }
        }

		// stop the stopwatch
		stopwatch.stop();
		System.out.println("Mongo: To save this data by reference in the database took "
				+ stopwatch.getTotalTimeMillis() + " milliseconds.");

        // start the stopwatch
		stopwatch = new StopWatch();
		stopwatch.start();

		// fetch owners
		List<Owner> ownerlist = ownerRepository.findAll();

		System.out.println("We fetched "+ownerlist.size()+" records");
		// stop the stopwatch
		stopwatch.stop();
		System.out.println("Mongo: To fetch this data by reference from the database took "
				+ stopwatch.getTotalTimeMillis() + " milliseconds.");
	}
}
