package com.recipeAppCore;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Item {
	
	private String MealName;
	private String MealType;
	private String MealDescription = "No Description Added";
	private HashMap<String, String> Ingredients = new HashMap<String, String>();
	private String imagePath;
	private String timestamp;
	private String method;
	
	public Item(){
		LocalDate obj = LocalDate.now();
		this.timestamp = obj.toString();
		
	}
	
	public String getMethod() {
		return this.method;
	}
	
	public void setMethod(String newMethod) {
		this.method = newMethod;
	}

	public String getTimestamp() {
		return this.timestamp;
		
	}
	public void setMealName(String name) {
		this.MealName = name;
	}
	
	public String getMealName() {
		return this.MealName;
	}
	
	public void setMealType(String type) {
		this.MealType = type;
	}
	
	public String getMealType() {
		return this.MealType;
	}
	
	public HashMap<String, String> getIngredients(){
		return this.Ingredients;
	}
	
	public void setMealDescription(String description) {
		this.MealDescription = description;
	}
	
	public String getMealDescription() {
		return this.MealDescription;
	}
	
	public void mealInfo() {
		System.out.println(MessageFormat.format("{0} \n{1} \n{2}\n{3} \n", MealName, MealType, MealDescription, timestamp));
	}
	
	public void addIngredient(String ingredient, String measure) {
		this.Ingredients.put(ingredient, measure);
	}
	
	public void printIngredients(HashMap<String, String> ingredients) {
		for (Map.Entry<String, String> ingredient : ingredients.entrySet()) {
			System.out.println(MessageFormat.format("{0} - {1}", ingredient.getKey(), ingredient.getValue()));
		}
	}
	
	public void setImagePath(String path) {
		this.imagePath = path;
	}
	public void openImage() throws IOException {
		BufferedImage myPicture = ImageIO.read(new File(imagePath));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		JPanel jPanel = new JPanel();
		jPanel.add(picLabel);
	}

}
