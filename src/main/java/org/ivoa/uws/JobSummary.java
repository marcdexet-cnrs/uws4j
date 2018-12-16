//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.1-b171012.0423 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.12.15 à 12:30:15 PM CET 
//


package org.ivoa.uws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.Element;


/**
 * 
 *             The complete representation of the state of a job
 *          
 * 
 * <p>Classe Java pour JobSummary complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="JobSummary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="jobId" type="{http://www.ivoa.net/xml/UWS/v1.0}JobIdentifier"/&gt;
 *         &lt;element name="runId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ownerId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="phase" type="{http://www.ivoa.net/xml/UWS/v1.0}ExecutionPhase"/&gt;
 *         &lt;element name="quote" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="creationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="executionDuration" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="destruction" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element ref="{http://www.ivoa.net/xml/UWS/v1.0}parameters" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.ivoa.net/xml/UWS/v1.0}results"/&gt;
 *         &lt;element name="errorSummary" type="{http://www.ivoa.net/xml/UWS/v1.0}ErrorSummary" minOccurs="0"/&gt;
 *         &lt;element name="jobInfo" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" type="{http://www.ivoa.net/xml/UWS/v1.0}UWSVersion" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobSummary", propOrder = {
    "jobId",
    "runId",
    "ownerId",
    "phase",
    "quote",
    "creationTime",
    "startTime",
    "endTime",
    "executionDuration",
    "destruction",
    "parameters",
    "results",
    "errorSummary",
    "jobInfo"
})
public class JobSummary {

    @XmlElement(required = true)
    protected String jobId;
    protected String runId;
    @XmlElement(required = true, nillable = true)
    protected String ownerId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ExecutionPhase phase;
    @XmlElementRef(name = "quote", namespace = "http://www.ivoa.net/xml/UWS/v1.0", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> quote;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTime;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    protected int executionDuration;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar destruction;
    protected Parameters parameters;
    @XmlElement(required = true)
    protected Results results;
    protected ErrorSummary errorSummary;
    protected JobSummary.JobInfo jobInfo;
    @XmlAttribute(name = "version")
    protected String version;

    /**
     * Obtient la valeur de la propriété jobId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * Définit la valeur de la propriété jobId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobId(String value) {
        this.jobId = value;
    }

    /**
     * Obtient la valeur de la propriété runId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunId() {
        return runId;
    }

    /**
     * Définit la valeur de la propriété runId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunId(String value) {
        this.runId = value;
    }

    /**
     * Obtient la valeur de la propriété ownerId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Définit la valeur de la propriété ownerId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerId(String value) {
        this.ownerId = value;
    }

    /**
     * Obtient la valeur de la propriété phase.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionPhase }
     *     
     */
    public ExecutionPhase getPhase() {
        return phase;
    }

    /**
     * Définit la valeur de la propriété phase.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionPhase }
     *     
     */
    public void setPhase(ExecutionPhase value) {
        this.phase = value;
    }

    /**
     * Obtient la valeur de la propriété quote.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getQuote() {
        return quote;
    }

    /**
     * Définit la valeur de la propriété quote.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setQuote(JAXBElement<XMLGregorianCalendar> value) {
        this.quote = value;
    }

    /**
     * Obtient la valeur de la propriété creationTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTime() {
        return creationTime;
    }

    /**
     * Définit la valeur de la propriété creationTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationTime(XMLGregorianCalendar value) {
        this.creationTime = value;
    }

    /**
     * Obtient la valeur de la propriété startTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Définit la valeur de la propriété startTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Obtient la valeur de la propriété endTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Définit la valeur de la propriété endTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndTime(XMLGregorianCalendar value) {
        this.endTime = value;
    }

    /**
     * Obtient la valeur de la propriété executionDuration.
     * 
     */
    public int getExecutionDuration() {
        return executionDuration;
    }

    /**
     * Définit la valeur de la propriété executionDuration.
     * 
     */
    public void setExecutionDuration(int value) {
        this.executionDuration = value;
    }

    /**
     * Obtient la valeur de la propriété destruction.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDestruction() {
        return destruction;
    }

    /**
     * Définit la valeur de la propriété destruction.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDestruction(XMLGregorianCalendar value) {
        this.destruction = value;
    }

    /**
     * 
     *                   The parameters to the job (where appropriate) can also
     *                   be retrieved at /{jobs}/{job-id}/parameters
     *                
     * 
     * @return
     *     possible object is
     *     {@link Parameters }
     *     
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * Définit la valeur de la propriété parameters.
     * 
     * @param value
     *     allowed object is
     *     {@link Parameters }
     *     
     */
    public void setParameters(Parameters value) {
        this.parameters = value;
    }

    /**
     * 
     *                   The results for the job - can also be retrieved at
     *                   /{jobs}/{job-id}/results
     *                
     * 
     * @return
     *     possible object is
     *     {@link Results }
     *     
     */
    public Results getResults() {
        return results;
    }

    /**
     * Définit la valeur de la propriété results.
     * 
     * @param value
     *     allowed object is
     *     {@link Results }
     *     
     */
    public void setResults(Results value) {
        this.results = value;
    }

    /**
     * Obtient la valeur de la propriété errorSummary.
     * 
     * @return
     *     possible object is
     *     {@link ErrorSummary }
     *     
     */
    public ErrorSummary getErrorSummary() {
        return errorSummary;
    }

    /**
     * Définit la valeur de la propriété errorSummary.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorSummary }
     *     
     */
    public void setErrorSummary(ErrorSummary value) {
        this.errorSummary = value;
    }

    /**
     * Obtient la valeur de la propriété jobInfo.
     * 
     * @return
     *     possible object is
     *     {@link JobSummary.JobInfo }
     *     
     */
    public JobSummary.JobInfo getJobInfo() {
        return jobInfo;
    }

    /**
     * Définit la valeur de la propriété jobInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JobSummary.JobInfo }
     *     
     */
    public void setJobInfo(JobSummary.JobInfo value) {
        this.jobInfo = value;
    }

    /**
     * Obtient la valeur de la propriété version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Définit la valeur de la propriété version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;any processContents='lax' maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class JobInfo {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Element }
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

    }

}
