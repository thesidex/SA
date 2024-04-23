package fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private OwnerService ownerService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// start the stopwatch
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		try {
			ownerService.successTransaction();
		} catch (Exception e) {
			System.out.println("Exception occurred during transaction: " + e.getMessage());
		}

		// stop the stopwatch
		stopwatch.stop();
		System.out.println("Mongo: Successfull Transaction took "
				+ stopwatch.getTotalTimeMillis() + " milliseconds.");

		// start the stopwatch
		stopwatch = new StopWatch();
		stopwatch.start();

		try {
			ownerService.failTransaction();
		} catch (Exception e) {
			System.out.println("Exception occurred during transaction: " + e.getMessage());
		}

		// stop the stopwatch
		stopwatch.stop();
		System.out.println("Mongo: Fail Transaction took "
				+ stopwatch.getTotalTimeMillis() + " milliseconds.");

		// start the stopwatch
		stopwatch = new StopWatch();
		stopwatch.start();

		try {
			ownerService.noTransaction();
		} catch (Exception e) {
			System.out.println("Exception occurred during transaction: " + e.getMessage());
		}

		// stop the stopwatch
		stopwatch.stop();
		System.out.println("Mongo: No Transaction took "
				+ stopwatch.getTotalTimeMillis() + " milliseconds.");
	}
}
