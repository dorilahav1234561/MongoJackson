package net.voigon.jackson.mongo.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.mongodb.MongoClientURI;

public class MongoClientURISerializer extends StdSerializer<MongoClientURI>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9030117670348068972L;

	protected MongoClientURISerializer() {
		super(MongoClientURI.class);
		
	}

	@Override
	public void serialize(MongoClientURI value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.toString());
		
	}

}
