package net.voigon.jackson.mongo.deser;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.mongodb.BasicDBObject;

public class BasicDBObjectDeserializer extends StdDeserializer<BasicDBObject> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2229950954445827427L;

	protected BasicDBObjectDeserializer() {
		super(BasicDBObject.class);
		
	}

	@Override
	public BasicDBObject deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new BasicDBObject(p.readValueAs(Map.class));
	}

}
