package net.voigon.jackson.bson.ser;

import java.io.IOException;
import java.util.ArrayList;

import org.bson.types.BasicBSONList;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BasicBSONListSerializer extends StdSerializer<BasicBSONList> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5503541694388669626L;

	protected BasicBSONListSerializer() {
		super(BasicBSONList.class);
		
	}


	@Override
	public void serialize(BasicBSONList value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeObject(new ArrayList<>(value));
		
	}

}
