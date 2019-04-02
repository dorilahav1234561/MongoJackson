package net.voigon.jackson.mongo;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.module.SimpleModule;

import net.voigon.jackson.bson.BsonAnnotationIntrospector;
import net.voigon.jackson.bson.deser.BsonDeserializers;
import net.voigon.jackson.bson.ser.BsonSerializers;

public class MongoModule extends SimpleModule {

	/**
	 *  JacksonAnnotationIntrospector 
	 */
	private static final long serialVersionUID = -1649589070089894501L;
	
	public MongoModule() {
		super("Mongo");
		
		setDeserializers(new BsonDeserializers());
		setSerializers(new BsonSerializers());
		
		setMixInAnnotation(BsonIgnore.class, JsonIgnore.class);
		setMixInAnnotation(BsonCreator.class, JsonCreator.class);
		setMixInAnnotation(BsonProperty.class, JsonProperty.class);
		
	}
	
	@Override
	public void setupModule(SetupContext context) {
		super.setupModule(context);
		
		ObjectMapper mapper = (ObjectMapper) context.getOwner();
		
		mapper.setAnnotationIntrospectors(
				AnnotationIntrospectorPair.pair(mapper.getSerializationConfig().getAnnotationIntrospector(), 
						new BsonAnnotationIntrospector()), 
				
				AnnotationIntrospectorPair.pair(mapper.getDeserializationConfig().getAnnotationIntrospector(), 
						new BsonAnnotationIntrospector()));
		
	}
		
}
