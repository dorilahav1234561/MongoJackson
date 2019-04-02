package net.voigon.jackson.bson.deser;

import java.awt.List;
import java.io.IOException;
import java.util.Collection;

import org.bson.types.BasicBSONList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BasicBSONListDeserializer extends StdDeserializer<BasicBSONList> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3034499240550237764L;

	protected BasicBSONListDeserializer() {
		super(BasicBSONList.class);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public BasicBSONList deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		BasicBSONList list = new BasicBSONList();
		list.addAll((Collection<? extends Object>) p.readValueAs(List.class));
		return list;
	}

}
