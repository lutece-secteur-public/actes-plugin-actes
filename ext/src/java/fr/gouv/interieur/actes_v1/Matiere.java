//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.11.15 at 01:18:12 AM CET 
//


package fr.gouv.interieur.actes_v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Matiere d'un acte (Code et libell�)
 * 
 * <p>Java class for Matiere complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Matiere">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}CodeMatiere use="required""/>
 *       &lt;attribute name="Libelle" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Matiere")
public class Matiere {

    @XmlAttribute(name = "CodeMatiere", namespace = "http://www.interieur.gouv.fr/ACTES#v1.1-20040216", required = true)
    protected BigInteger codeMatiere;
    @XmlAttribute(name = "Libelle", namespace = "http://www.interieur.gouv.fr/ACTES#v1.1-20040216", required = true)
    protected String libelle;

    /**
     * Gets the value of the codeMatiere property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodeMatiere() {
        return codeMatiere;
    }

    /**
     * Sets the value of the codeMatiere property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodeMatiere(BigInteger value) {
        this.codeMatiere = value;
    }

    /**
     * Gets the value of the libelle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets the value of the libelle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelle(String value) {
        this.libelle = value;
    }

}