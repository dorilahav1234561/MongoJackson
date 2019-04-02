package net.voigon.jackson.bson.deser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ObjectIdDeserializer extends StdDeserializer<ObjectId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8917713633869909210L;

	protected ObjectIdDeserializer() {
		super(ObjectId.class);
		
	}

	@Override
	public ObjectId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectMapper mapper = ((ObjectMapper) p.getCodec());
		Map<String, String> map = mapper.readValue(p, mapper.getTypeFactory().constructMapType(HashMap.class, String.class, String.class));
		return new ObjectId(map.get("$oid"));
	}

}
