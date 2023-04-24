/**
 * @author Freel - kjfreel
 * CIS175 - Spring 2023
 * Apr 23, 2023
 */
package recipe.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import recipe.beans.Recipe;

import org.springframework.stereotype.Repository;

//@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}