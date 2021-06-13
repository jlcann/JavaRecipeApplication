package com.recipeAppCore;

public class Lunch extends Item {
	
	private String MealType = "Lunch";

	public Lunch(String dishName) {
		this.setMealName(dishName);
		this.setMealType(MealType);
	}
		
}
