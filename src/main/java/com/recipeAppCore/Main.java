package com.recipeAppCore;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.concurrent.ExecutionException;

import com.recipeAppDatabaseController.FirebaseController;


public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
//		Breakfast test = new Breakfast("Avocado Toast");
//		test.SetMealDescription("Lovely Toast with some lovely avocado");
//		
//		test.addIngredient("Bread", "One Slice");
//		test.addIngredient("Butter", "Two Teaspoons");
//		test.addIngredient("Avocado", "One Whole");
//		test.addIngredient("Salt", "A Pinch");
//		test.addIngredient("Pepper", "A Pinch");
//		test.addIngredient("Tomato", "Three to four cherry");
//		
//		test.printIngredients();
//		test.MealInfo();

		FirebaseController test = new FirebaseController();
		
		String desc = test.getMealDescription("Avocado Toast");
		String name = test.getMealName("Avocado Toast");
		String type = test.getMealType("Avocado Toast");
		String timestamp = test.getMealTimestamp("Avocado Toast");
		//String ingredients = test.getMealIngredients("Avocado Toast");
		
		System.out.println(MessageFormat.format("{0}\n{1}\n{2}\n{3}\n", name, type, desc, timestamp));
		
		//System.out.println(timestamp);
		
		}
		
}
