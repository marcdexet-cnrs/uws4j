//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.1-b171012.0423 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.12.15 à 12:30:15 PM CET 
//


package org.ivoa.uws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.ivoa.uws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Job_QNAME = new QName("http://www.ivoa.net/xml/UWS/v1.0", "job");
    private final static QName _ShortJobDescriptionOwnerId_QNAME = new QName("http://www.ivoa.net/xml/UWS/v1.0", "ownerId");
    private final static QName _JobSummaryQuote_QNAME = new QName("http://www.ivoa.net/xml/UWS/v1.0", "quote");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.ivoa.uws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JobSummary }
     * 
     */
    public JobSummary createJobSummary() {
        return new JobSummary();
    }

    /**
     * Create an instance of {@link Jobs }
     * 
     */
    public Jobs createJobs() {
        return new Jobs();
    }

    /**
     * Create an instance of {@link ShortJobDescription }
     * 
     */
    public ShortJobDescription createShortJobDescription() {
        return new ShortJobDescription();
    }

    /**
     * Create an instance of {@link Results }
     * 
     */
    public Results createResults() {
        return new Results();
    }

    /**
     * Create an instance of {@link ResultReference }
     * 
     */
    public ResultReference createResultReference() {
        return new ResultReference();
    }

    /**
     * Create an instance of {@link Parameters }
     * 
     */
    public Parameters createParameters() {
        return new Parameters();
    }

    /**
     * Create an instance of {@link Parameter }
     * 
     */
    public Parameter createParameter() {
        return new Parameter();
    }

    /**
     * Create an instance of {@link ErrorSummary }
     * 
     */
    public ErrorSummary createErrorSummary() {
        return new ErrorSummary();
    }

    /**
     * Create an instance of {@link JobSummary.JobInfo }
     * 
     */
    public JobSummary.JobInfo createJobSummaryJobInfo() {
        return new JobSummary.JobInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JobSummary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JobSummary }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ivoa.net/xml/UWS/v1.0", name = "job")
    public JAXBElement<JobSummary> createJob(JobSummary value) {
        return new JAXBElement<JobSummary>(_Job_QNAME, JobSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ivoa.net/xml/UWS/v1.0", name = "ownerId", scope = ShortJobDescription.class)
    public JAXBElement<String> createShortJobDescriptionOwnerId(String value) {
        return new JAXBElement<String>(_ShortJobDescriptionOwnerId_QNAME, String.class, ShortJobDescription.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ivoa.net/xml/UWS/v1.0", name = "quote", scope = JobSummary.class)
    public JAXBElement<XMLGregorianCalendar> createJobSummaryQuote(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_JobSummaryQuote_QNAME, XMLGregorianCalendar.class, JobSummary.class, value);
    }

}
