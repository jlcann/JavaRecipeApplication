package com.recipeAppDatabaseController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.threeten.bp.LocalDate;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.recipeAppCore.Item;

public class FirebaseController {
	

	private Firestore database = null;
	

	public FirebaseController() throws IOException {
		this.database = getDatabase();
	}
	
	@SuppressWarnings("deprecation")
	
	public Firestore getDatabase() throws IOException {
		InputStream serviceAccount = new FileInputStream("C:/Users/Jack/git/serviceAccount.json");
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
		FirebaseApp.initializeApp(options);
		
		Firestore db = FirestoreClient.getFirestore();
		
		return db;
		
	}
	
	public String getMealDescription(String name) throws InterruptedException, ExecutionException, IOException {
		
		String returnVal = "";
		
		ApiFuture<QuerySnapshot> query = this.database.collection("recipes").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			if (document.getString("Name").equalsIgnoreCase(name)) {
				 returnVal = document.getString("Description");
			}
		}
		
		return returnVal;
		
	}
	
	public String getMealName(String name) throws InterruptedException, ExecutionException, IOException {
		
		String returnVal = "";
		
		ApiFuture<QuerySnapshot> query = this.database.collection("recipes").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			if (document.getString("Name").equalsIgnoreCase(name)) {
				 returnVal = document.getString("Name");
			}
		}
		return returnVal;
		
	}
	
	public String getMealMethod(String name) throws InterruptedException, ExecutionException, IOException {
		
		String returnVal = "";
		
		ApiFuture<QuerySnapshot> query = this.database.collection("recipes").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			if (document.getString("Name").equalsIgnoreCase(name)) {
				 returnVal = document.getString("Method");
			}
		}
		return returnVal;
		
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, String> getMealIngredients(String name) throws InterruptedException, ExecutionException, IOException {
		
		HashMap<String, String> returnVal = null;
		
		ApiFuture<QuerySnapshot> query = this.database.collection("recipes").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			if (document.getString("Name").equalsIgnoreCase(name)) {
				 returnVal = (HashMap<String, String>) document.get("Ingredients");			 
			}
		}
		
		return returnVal;
		
	}
	
	public String getMealType(String name) throws InterruptedException, ExecutionException, IOException {
		
		String returnVal = "";
		
		
		ApiFuture<QuerySnapshot> query = this.database.collection("recipes").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			if (document.getString("Name").equalsIgnoreCase(name)) {
				 returnVal = document.getString("Type");
			}
		}
		return returnVal;
		
	}
	
	public String getMealTimestamp(String name) throws InterruptedException, ExecutionException, IOException {
		
		String returnVal = "";
		
		
		ApiFuture<QuerySnapshot> query = this.database.collection("recipes").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			if (document.getString("Name").equalsIgnoreCase(name)) {
				 returnVal = document.getString("Timestamp");
			}
		}
		return returnVal;
		
	}
	
	public void createNewMeal(Item newMeal) throws InterruptedException, ExecutionException {
		
		ArrayList<String> allMealNames = this.getAllMealNames();
		
		if (allMealNames.contains(newMeal.getMealName())){
			System.out.println(MessageFormat.format("This Database Already Contains a Meal Named -{0}-", newMeal.getMealName()));
			System.out.println("aborted");
		} else {
			Map<String, Object> docData = new HashMap<String, Object>();
			
			docData.put("Name", newMeal.getMealName());
			docData.put("Type", newMeal.getMealType());
			docData.put("Description", newMeal.getMealDescription());
			docData.put("Ingredients", newMeal.getIngredients());
			docData.put("Method", newMeal.getMethod());
			docData.put("Timestamp", LocalDate.now().toString());
			
			ApiFuture<WriteResult> future = this.database.collection("recipes").document(newMeal.getMealName()).set(docData);

			System.out.println("Meal Successfully Created - Time : " + future.get().getUpdateTime());
		}
		
		
		
		
	}
	
	public void updateMeal(String meal, String field, Object newData) throws InterruptedException, ExecutionException {
		// Update an existing document
		DocumentReference docRef = this.database.collection("recipes").document(meal);

		// (async) Update one field
		ApiFuture<WriteResult> future = docRef.update(field, newData);

		// ...
		WriteResult result = future.get();
		System.out.println("Write result: " + result);
	}
	
	public ArrayList<String> getAllMealNames() throws InterruptedException, ExecutionException {
		ArrayList<String> meals = new ArrayList<String>();
		
		ApiFuture<QuerySnapshot> query = this.database.collection("recipes").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			meals.add(document.getString("Name"));

		}
		
		return meals;
		
		
	}

}
