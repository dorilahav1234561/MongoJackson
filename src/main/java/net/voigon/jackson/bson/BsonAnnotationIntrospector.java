package net.voigon.jackson.bson;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;

public class BsonAnnotationIntrospector extends NopAnnotationIntrospector  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3858642443841120333L;
	
	@Override
	public PropertyName findNameForDeserialization(Annotated a) {
		return idPropertySupport(a);
	}
	
	@Override
	public PropertyName findNameForSerialization(Annotated a) {
		return idPropertySupport(a);
	}
	
	PropertyName idPropertySupport(Annotated a) {
		if (!a.hasAnnotation(IdProperty.class)) return null;
		return PropertyName.construct("_id");
	}
	

}
