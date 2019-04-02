package net.voigon.jackson.mongo.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.mongodb.MongoNamespace;

public class MongoNamespaceSerializer extends StdSerializer<MongoNamespace> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2832846371447608339L;

	protected MongoNamespaceSerializer() {
		super(MongoNamespace.class);
		
	}

	@Override
	public void serialize(MongoNamespace value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("database", value.getDatabaseName());
		gen.writeStringField("collection", value.getCollectionName());
		gen.writeEndObject();
		
	}

}
