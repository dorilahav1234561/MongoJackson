package net.voigon.jackson.mongo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JacksonMongoCollection<T> {

	@Getter @NonNull
	final MongoCollection<Document>
			collection;
	
	@Getter @NonNull
	final ObjectMapper
			mapper;
	
	@Getter @NonNull
	final Class<T>
			clazz;
	
	boolean
			init;
	
	public Set<T> find() {
		init();
		
		FindIterable<Document> iter = collection.find();
		Set<T> set = new HashSet<>();
		
		for(Document document : iter.into(new HashSet<>()))
			set.add(documentToValue(document));
		
		return set;
	}
	
	public Set<T> find(@NonNull Bson bson) {
		init();
		
		FindIterable<Document> iter = collection.find(bson);
		Set<T> set = new HashSet<>();
		
		for (Document document : iter.into(new HashSet<>())) 
			set.add(documentToValue(document));
		
		return set;
	}
	
	public T findFirst(@NonNull Bson bson) {
		init();
		
		return documentToValue(collection.find(bson).limit(1).first());
	}
	
	public T findFirstOrNull(@NonNull Bson bson) {
		init();
		
		Document doc = collection.find(bson).limit(1).first();
		
		return doc != null ? documentToValue(doc) : null;
	}
	
	public void insertMany(@NonNull @SuppressWarnings("unchecked") T... values) {
		init();
		
		List<Document> list = new ArrayList<>();
		for (T value : values) 
			list.add(valueToDocument(value));			
		
		collection.insertMany(list);
		
	}
	
	public void insertOne(@NonNull T value) {
		init();
		
		collection.insertOne(valueToDocument(value));
		
	}
	
	public void findOneAndReplace(@NonNull Bson bson, @NonNull T value) {
		init();
		
		collection.findOneAndReplace(bson, valueToDocument(value));
	}
	
	public void findOneAndDelete(@NonNull Bson bson) {
		init();
		
		collection.findOneAndDelete(bson);
	}
	
	protected void init() {
		if (!init) {
			init = true;
			mapper.registerModule(new MongoModule());	
		}

	}
	
	public Document valueToDocument(T value) {
		return mapper.convertValue(value, Document.class);
	}

	public T documentToValue(Document document) {
		if (document == null)
			return null;

		// Optional operation
		document.remove("_id");
		
		return mapper.convertValue(document, clazz);
	}
	
}
