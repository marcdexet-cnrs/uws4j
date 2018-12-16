//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.1-b171012.0423 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2018.12.15 à 12:30:15 PM CET 
//


package org.ivoa.uws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ExecutionPhase.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ExecutionPhase"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PENDING"/&gt;
 *     &lt;enumeration value="QUEUED"/&gt;
 *     &lt;enumeration value="EXECUTING"/&gt;
 *     &lt;enumeration value="COMPLETED"/&gt;
 *     &lt;enumeration value="ERROR"/&gt;
 *     &lt;enumeration value="UNKNOWN"/&gt;
 *     &lt;enumeration value="HELD"/&gt;
 *     &lt;enumeration value="SUSPENDED"/&gt;
 *     &lt;enumeration value="ABORTED"/&gt;
 *     &lt;enumeration value="ARCHIVED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExecutionPhase")
@XmlEnum
public enum ExecutionPhase {


    /**
     * 
     *                   The first phase a job is entered into - this is where
     *                   a job is being set up but no request to run has
     *                   occurred.
     *                
     * 
     */
    PENDING,

    /**
     * 
     *                   A job has been accepted for execution but is waiting
     *                   in a queue
     *                
     * 
     */
    QUEUED,

    /**
     * A job is running
     * 
     */
    EXECUTING,

    /**
     * 
     *                   A job has completed successfully
     *                
     * 
     */
    COMPLETED,

    /**
     * 
     *                   Some form of error has occurred
     *                
     * 
     */
    ERROR,

    /**
     * 
     *                   The job is in an unknown state.
     *                
     * 
     */
    UNKNOWN,

    /**
     * 
     *                   The job is HELD pending execution and will not
     *                   automatically be executed - can occur after a
     *                   PHASE=RUN request has been made (cf PENDING).
     *                
     * 
     */
    HELD,

    /**
     * 
     *                   The job has been suspended by the system during
     *                   execution
     *                
     * 
     */
    SUSPENDED,

    /**
     * 
     *                   The job has been aborted, either by user request or by
     *                   the server because of lack or overuse of resources.
     *                
     * 
     */
    ABORTED,

    /**
     * 
     *                   The job has been archived by the server at destruction time. An archived job
     *                   may have deleted the results to reclaim resources, but must have job metadata preserved.
     *                   This is an alternative that the server may choose in contrast to completely destroying all record of the job.
     *                
     * 
     */
    ARCHIVED;

    public String value() {
        return name();
    }

    public static ExecutionPhase fromValue(String v) {
        return valueOf(v);
    }

}
