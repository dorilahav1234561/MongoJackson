package net.voigon.jackson.bson.codec;

import java.io.IOException;

import org.bson.BsonDocument;
import org.bson.Document;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BsonDocumentDeserializer extends StdDeserializer<BsonDocument> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6835702420008557290L;

	BsonModule 
			module;
	
	protected BsonDocumentDeserializer(BsonModule module) {
		super(BsonDocument.class);
		
		this.module = module;
		
	}


	@Override
	public BsonDocument deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return p.getCodec().readValue(p, Document.class).toBsonDocument(null /* */, module.getCodecRegistry());
	}

}
