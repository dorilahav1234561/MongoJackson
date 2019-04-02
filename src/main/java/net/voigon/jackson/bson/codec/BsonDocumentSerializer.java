package net.voigon.jackson.bson.codec;

import java.io.IOException;

import org.bson.BsonDocument;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BsonDocumentSerializer extends StdSerializer<BsonDocument> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4659684160903992141L;

	protected BsonDocumentSerializer() {
		super(BsonDocument.class);

	}


	@Override
	public void serialize(BsonDocument value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		value.asArray();
		value.asBoolean();
		value.asBinary();
		value.asDateTime();
		value.asDBPointer();
		value.asDecimal128();
		value.asDocument();
		value.asDouble();
		value.asInt32();
		value.asInt64();
		value.asJavaScript();
		value.asJavaScriptWithScope();
		value.asNumber();
		value.asObjectId();
		value.asRegularExpression();
		value.asString();
		value.asSymbol();
		value.asTimestamp();
		
		
		
		
	}

}
