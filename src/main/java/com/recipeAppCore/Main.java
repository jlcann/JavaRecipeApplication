package com.recipeAppCore;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import com.recipeAppDatabaseController.FirebaseController;


public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		/**
		 * Create a new meal object
		 */
		Breakfast test = new Breakfast("Avocado Toast");
		test.SetMealDescription("Lovely Toast with some lovely avocado");
		test.addIngredient("Bread", "One Slice");
		test.addIngredient("Butter", "Two Teaspoons");
		test.addIngredient("Avocado", "One Whole");
		test.addIngredient("Salt", "A Pinch");
		test.addIngredient("Pepper", "A Pinch");
		test.addIngredient("Tomato", "Three to four cherry");
		
		
		
//		test.printIngredients();
//		test.MealInfo();
		
		
		/**
		 * Create a new database controller
		 */
		FirebaseController fb = new FirebaseController();
		
		
		/**
		 * Add meal object to FireBase
		 */
		fb.createNewMeal(test);
		
		/**
		 * Get some info from the database
		 */
		
//		String desc = fb.getMealDescription("Avocado Toast");
//		String name = fb.getMealName("Avocado Toast");
//		String type = fb.getMealType("Avocado Toast");
//		String timestamp = fb.getMealTimestamp("Avocado Toast");
//		String ingredients = fb.getMealIngredients("Avocado Toast");
		
		/**
		 * Testing the update function
		 */
		
//		HashMap<String, String> new_ingredients = new HashMap<String, String>();
//		new_ingredients.put("New Test Ingredient", "New Test Measure");	
//		fb.updateMeal("Avocado Toast", "Ingredients", new_ingredients);
		
		/**
		 * Print out the info from database
		 */
		
//		System.out.println(MessageFormat.format("{0}\n{1}\n{2}\n{3}\n", name, type, desc, timestamp));
		
		/**
		 * Test get all meal names
		 */
		
//		ArrayList<String> mealNamesTest = fb.getAllMealNames();
//		System.out.println(mealNamesTest);
		
		
		}
		
}
