package org.database;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DataAccessJson extends DataAccess {

	protected String Extension = ".json";

	public DataAccessJson(File r) {
		super(r);
	}
	
	public DataAccessJson() {
		super();
	}

	@Override
	public <T1> void writeList(List<T1> items, File f) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper m = new ObjectMapper();
		m.writeValue(f, items);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> readList(File f) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper m = new ObjectMapper();
		return (List<Object>)m.readValue(f, Object.class);
	}

}
