package net.voigon.jackson.mongo.deser;

import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoNamespace;

import net.voigon.jackson.bson.deser.BsonDeserializers;

public class MongoDeserializers extends SimpleDeserializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5765826032827967786L;
	
	public MongoDeserializers() {
		addDeserializer(MongoClientURI.class, new MongoClientURIDeserializer());
		addDeserializer(MongoNamespace.class, new MongoNamespaceDeserializer());
		addDeserializer(BasicDBObject.class, new BasicDBObjectDeserializer());
		addDeserializer(BasicDBList.class, new BasicDBListDeserializer());
		
		BsonDeserializers bson = new BsonDeserializers();
		_classMappings.putAll(bson.getMappings());
		
		if (bson.hasEnumDeserializer())
			_hasEnumDeserializer = true;
		
	}
	
	void addDeserializer(Entry<ClassKey, JsonDeserializer<?>> entry) {
		_classMappings.put(entry.getKey(), entry.getValue());
		
		
	}
}
