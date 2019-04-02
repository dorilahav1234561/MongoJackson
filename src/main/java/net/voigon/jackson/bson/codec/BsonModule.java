package net.voigon.jackson.bson.codec;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;

import com.fasterxml.jackson.databind.module.SimpleModule;

import lombok.Getter;

public class BsonModule extends SimpleModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5189666615247075439L;
	
	@Getter
	CodecRegistry
			codecRegistry;
	
	public BsonModule(CodecRegistry registry) {
		super("Bson");
		
		setDeserializers(new CodecDeserializers(this));
		setSerializers(new CodecSerializers(this));
		
	}
	
	public BsonModule withCodecs(Codec<?>... codecs) {
		for (Codec<?> codec : codecs) 
			withCodec(codec);
		
		return this;
	}
	
	public BsonModule withCodec(Iterable<Codec<?>> codecs) {		
		codecs.forEach((codec) -> withCodec(codec));
		return this;
	}
	
	public <T> BsonModule withCodec(Codec<T> codec) {
		addSerializer(new CodecSerializer<>(codec.getEncoderClass(), codec));
		addDeserializer(codec.getEncoderClass(), new CodecDeserializer<>(codec.getEncoderClass(), codec));
		return this;
	}
}
