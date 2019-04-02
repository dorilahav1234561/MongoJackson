package net.voigon.jackson.bson.codec;

import java.io.IOException;

import org.bson.BsonDocument;
import org.bson.BsonDocumentReader;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CodecDeserializer<T> extends StdDeserializer<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3906117837585159062L;
	
	final Codec<T> 
			codec;
	
	protected CodecDeserializer(JavaType type, Codec<T> codec) {
		super(type);
		
		this.codec = codec;
		
	}
	
	protected CodecDeserializer(Class<T> type, Codec<T> codec) {
		super(type);
		
		this.codec = codec;
		
	}

		
	@Override
	public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return codec.decode(
				new BsonDocumentReader(p.readValueAs(BsonDocument.class)), 
				DecoderContext.builder().build());
	}

}
