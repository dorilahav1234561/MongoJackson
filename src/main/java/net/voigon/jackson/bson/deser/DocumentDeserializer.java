package net.voigon.jackson.bson.deser;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DocumentDeserializer extends StdDeserializer<Document> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7885850710435829662L;

	protected DocumentDeserializer() {
		super(Document.class);
		
	}

	@Override
	public Document deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectMapper mapper = ((ObjectMapper)p.getCodec());
		return new Document(mapper.readValue(p, mapper.getTypeFactory().constructMapType(LinkedHashMap.class, String.class, Object.class)));
	}

}
