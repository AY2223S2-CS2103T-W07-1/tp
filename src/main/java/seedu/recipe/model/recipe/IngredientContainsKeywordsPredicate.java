package seedu.recipe.model.recipe;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import seedu.recipe.commons.util.StringUtil;

/**
 * Tests that a {@code Recipe}'s {@code Ingredient} matches any of the keywords given.
 */
public class IngredientContainsKeywordsPredicate implements Predicate<Recipe> {
    private final List<String> keywords;

    public IngredientContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Recipe recipe) {
        Set<Ingredient> recipeIngredients = recipe.getIngredients();
        for (Ingredient i : recipeIngredients) {
            if (keywords.stream().anyMatch(keyword -> StringUtil.containsWordIgnoreCase(i.ingredient, keyword))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof IngredientContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((IngredientContainsKeywordsPredicate) other).keywords)); // state check
    }

}
