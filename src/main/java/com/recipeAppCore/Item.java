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
	
	public Item(){
		LocalDate obj = LocalDate.now();
		this.timestamp = obj.toString();
		
	}

	public String getTimestamp() {
		return this.timestamp;
		
	}
	public void SetMealName(String name) {
		this.MealName = name;
	}
	
	public String getMealName() {
		return this.MealName;
	}
	
	public void SetMealType(String type) {
		this.MealType = type;
	}
	
	public String getMealType() {
		return this.MealType;
	}
	
	public void SetMealDescription(String description) {
		this.MealDescription = description;
	}
	
	public String getMealDescription() {
		return this.MealDescription;
	}
	
	public void MealInfo() {
		System.out.println(MessageFormat.format("{0} \n{1} \n{2}\n{3} \n", MealName, MealType, MealDescription, timestamp));
		printIngredients();
	}
	
	public void addIngredient(String ingredient, String measure) {
		this.Ingredients.put(ingredient, measure);
	}
	
	public void printIngredients() {
		for (Map.Entry<String, String> ingredients : this.Ingredients.entrySet()) {
			System.out.println(MessageFormat.format("{0} - {1}", ingredients.getKey(), ingredients.getValue()));
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
