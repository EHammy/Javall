package recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import recipe.beans.Recipe;
import recipe.repository.RecipeRepository;

@Controller
public class RecipeController {
   @Autowired
   private RecipeRepository recipeRepository;

   @GetMapping({ "/", "viewAll" })
   public String viewAllRecipes(Model model) {
      if (recipeRepository.findAll().isEmpty()) {
         return addRecipeForm(model);
      }

      model.addAttribute("recipes", recipeRepository.findAll());
      return "recipes/list";
   }

   @GetMapping("/add")
   public String addRecipeForm(Model model) {
      Recipe recipe = new Recipe();
      model.addAttribute("recipe", recipe);
      return "recipes/form";
   }

//   @GetMapping("/edit/{id}")
//   public String editRecipeForm(@PathVariable Long id, Model model) {
//      Recipe recipe = recipeRepository.findById(id).orElse(null);
//      model.addAttribute("recipe", recipe);
//      return "recipes/form";
//   }
//
//   @PostMapping("/save")
//   public String saveRecipe(Recipe recipe, Model model) {
//      recipeRepository.save(recipe);
//      return "redirect:/recipes";
//   }
//
//   @PostMapping("/edit/{id}")
//   public String updateRecipe(@PathVariable Long id, Recipe recipe, Model model) {
//      recipe.setId(id);
//      recipeRepository.save(recipe);
//      return "redirect:/recipes";
//   }
//
//   @GetMapping("/delete/{id}")
//   public String deleteRecipe(@PathVariable Long id, Model model) {
//      recipeRepository.deleteById(id);
//      return "redirect:/recipes";
//   }
//}
}