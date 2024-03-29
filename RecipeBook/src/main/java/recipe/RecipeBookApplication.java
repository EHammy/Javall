package recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("recipe.repository")
public class RecipeBookApplication {
   public static void main(String[] args) {
      SpringApplication.run(RecipeBookApplication.class, args);
   }
}

