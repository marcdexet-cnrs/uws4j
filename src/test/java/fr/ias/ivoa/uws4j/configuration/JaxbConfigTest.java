package fr.ias.ivoa.uws4j.configuration;

import static org.assertj.core.api.Assertions.assertThat;

import org.ivoa.uws.Parameter;
import org.ivoa.uws.Parameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.xml.transform.StringResult;

@ExtendWith(SpringExtension.class)
@Import(JaxbConfig.class)
class JaxbConfigTest {

	@Autowired
	Jaxb2Marshaller marshaller;

	@Test
	void testMarshaller() {
		Parameters xmlParameters = new Parameters();
		Parameter parm = new Parameter();
		parm.setId("foo");
		parm.setContent("bar");
		xmlParameters.getParameter().add(parm);
		StringResult result = new StringResult();
		marshaller.marshal(xmlParameters, result);
		assertThat(result.toString())
			.isEqualTo(
					"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
								+ "<parameters xmlns=\"http://www.ivoa.net/xml/UWS/v1.0\" xmlns:ns2=\"http://www.w3.org/1999/xlink\">"
					+ "<parameter id=\"foo\">bar</parameter>"
					+ "</parameters>");
	}

}
