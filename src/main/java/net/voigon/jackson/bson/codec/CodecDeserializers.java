package net.voigon.jackson.bson.codec;

import org.bson.codecs.Codec;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CodecDeserializers extends SimpleDeserializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7617520275662565500L;
	
	final BsonModule
			module;
	
	@Override
	public JsonDeserializer<?> findArrayDeserializer(ArrayType type, DeserializationConfig config,
			BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
			throws JsonMappingException {
		return get(type, config, beanDesc);
	}
	
	@Override
	public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config,
			BeanDescription beanDesc) throws JsonMappingException {
		return get(type, config, beanDesc);
	}
	
	@Override
	public JsonDeserializer<?> findCollectionDeserializer(CollectionType type, DeserializationConfig config,
			BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
			throws JsonMappingException {
		return get(type, config, beanDesc);
	}
	
	@Override
	public JsonDeserializer<?> findCollectionLikeDeserializer(CollectionLikeType type, DeserializationConfig config,
			BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer)
			throws JsonMappingException {
		return get(type, config, beanDesc);
	}
		
	@Override
	public JsonDeserializer<?> findMapDeserializer(MapType type, DeserializationConfig config, BeanDescription beanDesc,
			KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer,
			JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
		return get(type, config, beanDesc);
	}
	
	@Override
	public JsonDeserializer<?> findMapLikeDeserializer(MapLikeType type, DeserializationConfig config,
			BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer,
			JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
		return get(type, config, beanDesc);
	}
		
	JsonDeserializer<?> get(JavaType nodeType,
			DeserializationConfig config, BeanDescription beanDesc) {
		Codec<?> codec = module.codecRegistry.get(nodeType.getRawClass());
		return codec == null ? _classMappings.get(new ClassKey(nodeType.getRawClass())) : new CodecDeserializer<>(nodeType, codec);
	}
	
}
