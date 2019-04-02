package net.voigon.jackson.mongo.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.mongodb.MongoClientURI;

public class MongoClientURIDeserializer extends StdDeserializer<MongoClientURI> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6912243934347584112L;
	
	protected MongoClientURIDeserializer() {
		super(MongoClientURI.class);
		
	}

	@Override
	public MongoClientURI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return new MongoClientURI(p.getValueAsString());
	}

}
