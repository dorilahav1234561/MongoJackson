package net.voigon.jackson.mongo.ser;

import com.fasterxml.jackson.databind.module.SimpleSerializers;

import net.voigon.jackson.bson.ser.BsonSerializers;

public class MongoSerializers extends SimpleSerializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = 236174638029698846L;

	public MongoSerializers() {
		addSerializer(new MongoClientURISerializer());
		addSerializer(new MongoNamespaceSerializer());
		
		BsonSerializers bson = new BsonSerializers();
		_classMappings.putAll(bson.getClassMappings());
		_interfaceMappings.putAll(bson.getInterfaceMappings());
		
		if (bson.hasEnumSerializer())
			_hasEnumSerializer = true;
		
	}
}
