package fr.ias.ivoa.uws4j.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.ivoa.uws.Parameter;
import org.ivoa.uws.Parameters;
import org.ivoa.uws.ResultReference;
import org.ivoa.uws.Results;
import org.springframework.stereotype.Service;

import fr.ias.ivoa.uws4j.domain.Result;

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
		} else if (Results.class.isAssignableFrom(classT)) {
			
			if ( value instanceof List ) {
				List<Result> jsonResultList = (List<Result>) value;
				Results xmlResults = new Results();
				for (Result jsonResult : jsonResultList) {
					ResultReference xmlResult = new ResultReference();
					xmlResult.setHref(jsonResult.getHref());
					xmlResult.setId(jsonResult.getId());
					xmlResult.setMimeType(jsonResult.getMimeType());
					xmlResult.setSize(jsonResult.getSize());
					xmlResult.setType(jsonResult.getType());
					xmlResults.getResult().add(xmlResult);
				}
				return (T) xmlResults;
			}
			
		}
			
		return null;
	}

}
