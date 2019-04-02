package net.voigon.jackson.bson.ser;

import java.io.IOException;

import org.bson.types.BSONTimestamp;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BSONTimestampSerializer extends StdSerializer<BSONTimestamp> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8770529032269025345L;

	protected BSONTimestampSerializer() {
		super(BSONTimestamp.class);
		
	}

	@Override
	public void serialize(BSONTimestamp value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("seconds", value.getTime());
		gen.writeNumberField("increment", value.getInc());
		gen.writeEndObject();
		
	}

}
