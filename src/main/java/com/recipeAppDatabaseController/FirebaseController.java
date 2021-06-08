package com.recipeAppDatabaseController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class FirebaseController {
	
	private ApiFuture<QuerySnapshot> query = null;

	public FirebaseController() throws IOException {
		this.query = getDatabase().collection("recipes").get();
	}
	
	@SuppressWarnings("deprecation")
	
	public Firestore getDatabase() throws IOException {
		InputStream serviceAccount = new FileInputStream("G:/Java/serviceAccount.json");
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
		FirebaseApp.initializeApp(options);
		
		Firestore db = FirestoreClient.getFirestore();
		
		return db;
		
	}
	
	public String getMealDescription(String name) throws InterruptedException, ExecutionException, IOException {
		
		String returnVal = "";
		
		QuerySnapshot querySnapshot = this.query.get();
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
		
		QuerySnapshot querySnapshot = this.query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			if (document.getString("Name").equalsIgnoreCase(name)) {
				 returnVal = document.getString("Name");
			}
		}
		return returnVal;
		
	}
	
	public String getMealIngredients(String name) throws InterruptedException, ExecutionException, IOException {
		
		String returnVal = "";
		
		QuerySnapshot querySnapshot = this.query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			if (document.getString("Name").equalsIgnoreCase(name)) {
				 returnVal = document.getString("Ingredients");
			}
		}
		return returnVal;
		
	}
	
	public String getMealType(String name) throws InterruptedException, ExecutionException, IOException {
		
		String returnVal = "";
		
		
		QuerySnapshot querySnapshot = this.query.get();
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
		
		
		QuerySnapshot querySnapshot = this.query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			if (document.getString("Name").equalsIgnoreCase(name)) {
				 returnVal = document.getString("Timestamp");
			}
		}
		return returnVal;
		
	}
	
	
	
	
}
