package fr.ias.ivoa.uws4j.services;

import java.util.Map;
import java.util.Map.Entry;

import org.ivoa.uws.Parameter;
import org.ivoa.uws.Parameters;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

	@SuppressWarnings("unchecked")
	public <T> T translateToXML(Class<T> classT, Object value) {
		if ( Parameters.class.isAssignableFrom(classT)) {
			
			if ( value instanceof Map ) {
			Map<String, String> parameters = (Map<String, String>) value;
			Parameters xmlParameters =  new Parameters();
			for (Entry<String, String> entry : parameters.entrySet()) {
				Parameter parm =  new Parameter();
				parm.setId(entry.getKey());
				parm.setContent(entry.getValue());
				xmlParameters.getParameter().add(parm);
			}
			return (T) xmlParameters;
			}
		}
		return null;
	}

}
