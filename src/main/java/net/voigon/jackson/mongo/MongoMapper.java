package net.voigon.jackson.mongo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MongoMapper extends ObjectMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5142567621750499229L;

	public MongoMapper() {
		registerModule(new MongoModule());
		
	}
	
	
	
}
