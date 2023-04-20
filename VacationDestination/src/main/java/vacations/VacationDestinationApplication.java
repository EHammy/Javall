package vacations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.EntityManagerFactory;
import vacations.beans.Activity;
import vacations.beans.Destination;
import vacations.repository.DestinationRepository;

@SpringBootApplication
public class VacationDestinationApplication implements CommandLineRunner {

    @Autowired
    private DestinationRepository destinationRepository;

    public static void main(String[] args) {
        SpringApplication.run(VacationDestinationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a new destination
        Destination destination = new Destination("New York City", "The Big Apple", "nyc.jpg");
        destinationRepository.save(destination);

        // Create a new activity associated with the destination
        Activity activity = new Activity("Visit the Empire State Building", "New York City", "Take in the views from the observation deck", 25.00);
        destination.addActivity(activity);
        destinationRepository.save(destination);

        // Retrieve destinations by name
        List<Destination> destinations = destinationRepository.findByNameContainingIgnoreCase("york");
        for (Destination dest : destinations) {
            System.out.println(dest);
        }
    }
}

