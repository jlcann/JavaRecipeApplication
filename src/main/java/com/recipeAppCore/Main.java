package com.recipeAppCore;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import com.recipeAppDatabaseController.FirebaseController;
import com.recipeAppCore.Item;


public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		/**
		 * Create a new meal object
		 */
//		Breakfast test = new Breakfast("Avocado Toast");
//		test.setMealDescription("Lovely Toast with some lovely avocado");
//		test.setMethod("Toast some bread, butter it, smash up some\navocado and spread onto toast, crack some\nsalt and pepper and garnish with the chopped tomatoes");
//		test.addIngredient("Bread", "One Slice");
//		test.addIngredient("Butter", "Two Teaspoons");
//		test.addIngredient("Avocado", "One Whole");
//		test.addIngredient("Salt", "A Pinch");
//		test.addIngredient("Pepper", "A Pinch");
//		test.addIngredient("Tomato", "Three to four cherry");
		
		
		
//		test.printIngredients();
//		test.MealInfo();
		
		
		/**
		 * Create a new database controller
		 */
		FirebaseController fb = new FirebaseController();
		
		
		/**
		 * Add meal object to FireBase
		 */
//		fb.createNewMeal(test);
		
		/**
		 * Get some info from the database
		 */
		
		String desc = fb.getMealDescription("Avocado Toast");
		String name = fb.getMealName("Avocado Toast");
		String type = fb.getMealType("Avocado Toast");
		String timestamp = fb.getMealTimestamp("Avocado Toast");
		HashMap<String, String> ingredients = fb.getMealIngredients("Avocado Toast");
		String method = fb.getMealMethod("Avocado Toast");
		
		/**
		 * Testing the update function
		 */
		
//		HashMap<String, String> new_ingredients = new HashMap<String, String>();
//		new_ingredients.put("New Test Ingredient", "New Test Measure");	
//		fb.updateMeal("Avocado Toast", "Ingredients", new_ingredients);
		
		/**
		 * Print out the info from database
		 */
		
		Breakfast n = new Breakfast();
		
		System.out.println(MessageFormat.format("{0}\n{1}\n{2}\nLast Edited: {3}\n", name, type, desc, timestamp));
		System.out.println("Ingredients: \n");
		n.printIngredients(ingredients);
		System.out.println(MessageFormat.format("\nMethod:\n{0}", method));
		
		/**
		 * Test get all meal names
		 */

//		ArrayList<String> mealNamesTest = fb.getAllMealNames();
//		System.out.println(mealNamesTest);
		
		
		}
		
}
