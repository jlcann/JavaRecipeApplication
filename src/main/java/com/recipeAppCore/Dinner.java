package com.recipeAppCore;

public class Dinner extends Item{

	private String MealType = "Dinner";
	
	public Dinner(String dishName) {
		this.SetMealName(dishName);
		this.SetMealType(MealType);
	}
	
}
