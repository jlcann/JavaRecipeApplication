package com.recipeAppCore;

public class Dinner extends Item{

	private String MealType = "Dinner";
	
	public Dinner(String dishName) {
		this.setMealName(dishName);
		this.setMealType(MealType);
	}
	
}
