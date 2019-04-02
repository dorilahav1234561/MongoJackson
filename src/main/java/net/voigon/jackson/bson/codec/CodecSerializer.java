package net.voigon.jackson.bson.codec;

import java.io.IOException;
import java.util.Map;

import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.EncoderContext;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CodecSerializer<T> extends StdSerializer<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3351730756729067768L;
	
	final Codec<T> 
			codec;
	
	protected CodecSerializer(JavaType vc, Codec<T> codec) {
		super(vc);
		
		this.codec = codec;
		
	}
	
	protected CodecSerializer(Class<T> vc, Codec<T> codec) {
		super(vc);
		
		this.codec = codec;
		
	}


	@Override
	public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		BsonDocument doc = new BsonDocument();
		codec.encode(new BsonDocumentWriter(doc), value, EncoderContext.builder().build());
		gen.writeObject(((ObjectMapper)gen.getCodec()).readValue(doc.toJson(), Map.class));
		
	}

}
