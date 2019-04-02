package net.voigon.jackson.bson.ser;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.type.ClassKey;

public class BsonSerializers extends SimpleSerializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2081275828180233316L;

	public BsonSerializers() {
		addSerializer(new DocumentSerializer());
		addSerializer(new ObjectIdSerializer());
		addSerializer(new BsonObjectSerializer());
		addSerializer(new BasicBSONListSerializer());
		addSerializer(new BSONTimestampSerializer());
		
	}
	
	public Map<ClassKey,JsonSerializer<?>> getClassMappings() {
		return _classMappings;
	}
	
	public Map<ClassKey,JsonSerializer<?>> getInterfaceMappings() {
		return _interfaceMappings;
	}
	
	public boolean hasEnumSerializer() {
		return _hasEnumSerializer;
	}

	
}
