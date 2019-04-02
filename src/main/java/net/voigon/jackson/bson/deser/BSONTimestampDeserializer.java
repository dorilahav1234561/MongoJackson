package net.voigon.jackson.bson.deser;

import java.io.IOException;

import org.bson.types.BSONTimestamp;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BSONTimestampDeserializer extends StdDeserializer<BSONTimestamp> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 645032199394740779L;

	protected BSONTimestampDeserializer() {
		super(BSONTimestamp.class);
	}


	@Override
	public BSONTimestamp deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = p.readValueAsTree();
		return new BSONTimestamp(
				node.get("seconds").asInt(), 
				node.get("increment").asInt());
	}

}
