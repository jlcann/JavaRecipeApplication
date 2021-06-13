package com.recipeAppCore;

public class Breakfast extends Item{
	
	private String MealType = "Breakfast";
	
	public Breakfast() {
		super();
	}

	public Breakfast(String dishName) {
		super();
		this.setMealName(dishName);
		this.setMealType(MealType);

	}
	
	

}
