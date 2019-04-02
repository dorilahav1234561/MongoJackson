package net.voigon.jackson.bson.codec;

import org.bson.codecs.Codec;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CodecSerializers extends SimpleSerializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2453989918032838419L;
	
	
	final BsonModule
			module;
	
	@Override
	public JsonSerializer<?> findArraySerializer(SerializationConfig config, ArrayType type, BeanDescription beanDesc,
			TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) {
		return get(type);
	}
	
	@Override
	public JsonSerializer<?> findCollectionLikeSerializer(SerializationConfig config, CollectionLikeType type,
			BeanDescription beanDesc, TypeSerializer elementTypeSerializer,
			JsonSerializer<Object> elementValueSerializer) {
		return get(type);
	}
	
	@Override
	public JsonSerializer<?> findCollectionSerializer(SerializationConfig config, CollectionType type,
			BeanDescription beanDesc, TypeSerializer elementTypeSerializer,
			JsonSerializer<Object> elementValueSerializer) {
		return get(type);
	}
	
	@Override
	public JsonSerializer<?> findMapLikeSerializer(SerializationConfig config, MapLikeType type,
			BeanDescription beanDesc, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer,
			JsonSerializer<Object> elementValueSerializer) {
		return get(type);
	}
	
	@Override
	public JsonSerializer<?> findMapSerializer(SerializationConfig config, MapType type, BeanDescription beanDesc,
			JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer,
			JsonSerializer<Object> elementValueSerializer) {
		return get(type);
	}
	
	@Override
	public JsonSerializer<?> findReferenceSerializer(SerializationConfig config, ReferenceType type,
			BeanDescription beanDesc, TypeSerializer contentTypeSerializer,
			JsonSerializer<Object> contentValueSerializer) {
		return get(type);
	}
	
	@Override
	public JsonSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc) {
		return get(type);
	}
	
	JsonSerializer<?> get(JavaType type) {
		Codec<?> codec = module.getCodecRegistry().get(type.getRawClass());
		return codec == null ? _classMappings.get(new ClassKey(type.getRawClass())) : new CodecSerializer<>(type, codec);
	}
	
}
