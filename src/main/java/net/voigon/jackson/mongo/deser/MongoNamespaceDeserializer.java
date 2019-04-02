package net.voigon.jackson.mongo.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.mongodb.MongoNamespace;

public class MongoNamespaceDeserializer extends StdDeserializer<MongoNamespace> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6902927452392216837L;

	protected MongoNamespaceDeserializer() {
		super(MongoNamespace.class);

	}


	@Override
	public MongoNamespace deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = p.readValueAsTree();
		if (node.isTextual())
			return new MongoNamespace(node.asText());
		else if (node.isObject())
			return new MongoNamespace(node.get("database").asText(), node.get("collection").asText());
		
		return null;
	}

}
