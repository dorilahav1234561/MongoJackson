package net.voigon.jackson.mongo.deser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.mongodb.BasicDBList;

public class BasicDBListDeserializer extends StdDeserializer<BasicDBList> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6920588581953944906L;

	protected BasicDBListDeserializer() {
		super(BasicDBList.class);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public BasicDBList deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		BasicDBList list = new BasicDBList();
		list.addAll(p.readValueAs(List.class));
		return list;
	}

}
