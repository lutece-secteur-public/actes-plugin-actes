//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.11.15 at 01:18:12 AM CET 
//


package fr.gouv.interieur.actes_v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}DonneesCourrierPref">
 *       &lt;sequence>
 *         &lt;element name="Document" type="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}FichierSigne"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "document"
})
@XmlRootElement(name = "ReponseCourrierSimple")
public class ReponseCourrierSimple
    extends DonneesCourrierPref
{

    @XmlElement(name = "Document", required = true)
    protected FichierSigne document;

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link FichierSigne }
     *     
     */
    public FichierSigne getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link FichierSigne }
     *     
     */
    public void setDocument(FichierSigne value) {
        this.document = value;
    }

}
