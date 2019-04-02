package net.voigon.jackson.bson.ser;

import java.io.IOException;

import org.bson.BSONObject;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BsonObjectSerializer extends StdSerializer<BSONObject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1788249787235267806L;

	protected BsonObjectSerializer() {
		super(BSONObject.class);
		
	}


	@Override
	public void serialize(BSONObject value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeObject(value.toMap());
		
	}

}
