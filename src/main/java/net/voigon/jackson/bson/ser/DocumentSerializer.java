package net.voigon.jackson.bson.ser;

import java.io.IOException;
import java.util.HashMap;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DocumentSerializer extends StdSerializer<Document> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1733797015404060313L;

	protected DocumentSerializer() {
		super(Document.class);

	}

	@Override
	public void serialize(Document value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		((ObjectMapper) gen.getCodec()).writeValue(gen, new HashMap<>(value));
		
		
	}

}
