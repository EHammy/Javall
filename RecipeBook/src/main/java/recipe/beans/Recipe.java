/**
 * @author Freel - kjfreel
 * CIS175 - Spring 2023
 * Apr 23, 2023
 */
package recipe.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Recipe {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private String ingredients;
   private String instructions;
}
