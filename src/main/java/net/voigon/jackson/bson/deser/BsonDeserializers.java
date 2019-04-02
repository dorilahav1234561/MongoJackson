package net.voigon.jackson.bson.deser;

import java.util.Map;

import org.bson.Document;
import org.bson.types.BSONTimestamp;
import org.bson.types.BasicBSONList;
import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.type.ClassKey;

public class BsonDeserializers extends SimpleDeserializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = 71974813873444756L;

	public BsonDeserializers() {
		addDeserializer(Document.class, new DocumentDeserializer());
		addDeserializer(ObjectId.class, new ObjectIdDeserializer());
		addDeserializer(BasicBSONList.class, new BasicBSONListDeserializer());
		addDeserializer(BSONTimestamp.class, new BSONTimestampDeserializer());
		
	}
	
	public Map<ClassKey,JsonDeserializer<?>> getMappings() {
		return _classMappings;
	}
	
	public boolean hasEnumDeserializer() {
		return _hasEnumDeserializer;
	}
	
}
