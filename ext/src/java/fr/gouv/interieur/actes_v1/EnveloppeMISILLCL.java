//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.11.15 at 01:18:12 AM CET 
//


package fr.gouv.interieur.actes_v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Emetteur">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}IDSGAR"/>
 *                     &lt;element ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}IDPref"/>
 *                     &lt;element ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}IDSousPref"/>
 *                   &lt;/choice>
 *                   &lt;element ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Referent" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}FormulairesEnvoyes"/>
 *         &lt;element name="Destinataire">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute ref="{http://xml.insee.fr/schema}SIREN use="required""/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "emetteur",
    "formulairesEnvoyes",
    "destinataire"
})
@XmlRootElement(name = "EnveloppeMISILLCL")
public class EnveloppeMISILLCL {

    @XmlElement(name = "Emetteur", required = true)
    protected EnveloppeMISILLCL.Emetteur emetteur;
    @XmlElement(name = "FormulairesEnvoyes", required = true)
    protected FormulairesEnvoyes formulairesEnvoyes;
    @XmlElement(name = "Destinataire", required = true)
    protected EnveloppeMISILLCL.Destinataire destinataire;

    /**
     * Gets the value of the emetteur property.
     * 
     * @return
     *     possible object is
     *     {@link EnveloppeMISILLCL.Emetteur }
     *     
     */
    public EnveloppeMISILLCL.Emetteur getEmetteur() {
        return emetteur;
    }

    /**
     * Sets the value of the emetteur property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnveloppeMISILLCL.Emetteur }
     *     
     */
    public void setEmetteur(EnveloppeMISILLCL.Emetteur value) {
        this.emetteur = value;
    }

    /**
     * Liste des fichiers XML envoy�s
     * 
     * @return
     *     possible object is
     *     {@link FormulairesEnvoyes }
     *     
     */
    public FormulairesEnvoyes getFormulairesEnvoyes() {
        return formulairesEnvoyes;
    }

    /**
     * Liste des fichiers XML envoy�s
     * 
     * @param value
     *     allowed object is
     *     {@link FormulairesEnvoyes }
     *     
     */
    public void setFormulairesEnvoyes(FormulairesEnvoyes value) {
        this.formulairesEnvoyes = value;
    }

    /**
     * Gets the value of the destinataire property.
     * 
     * @return
     *     possible object is
     *     {@link EnveloppeMISILLCL.Destinataire }
     *     
     */
    public EnveloppeMISILLCL.Destinataire getDestinataire() {
        return destinataire;
    }

    /**
     * Sets the value of the destinataire property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnveloppeMISILLCL.Destinataire }
     *     
     */
    public void setDestinataire(EnveloppeMISILLCL.Destinataire value) {
        this.destinataire = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute ref="{http://xml.insee.fr/schema}SIREN use="required""/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Destinataire {

        @XmlAttribute(name = "SIREN", namespace = "http://xml.insee.fr/schema", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String siren;

        /**
         * Gets the value of the siren property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSIREN() {
            return siren;
        }

        /**
         * Sets the value of the siren property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSIREN(String value) {
            this.siren = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;choice>
     *           &lt;element ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}IDSGAR"/>
     *           &lt;element ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}IDPref"/>
     *           &lt;element ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}IDSousPref"/>
     *         &lt;/choice>
     *         &lt;element ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Referent" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "idsgar",
        "idPref",
        "idSousPref",
        "referent"
    })
    public static class Emetteur {

        @XmlElement(name = "IDSGAR")
        protected IDSGAR idsgar;
        @XmlElement(name = "IDPref")
        protected IDPref idPref;
        @XmlElement(name = "IDSousPref")
        protected IDSousPref idSousPref;
        @XmlElement(name = "Referent")
        protected Referent referent;

        /**
         * Gets the value of the idsgar property.
         * 
         * @return
         *     possible object is
         *     {@link IDSGAR }
         *     
         */
        public IDSGAR getIDSGAR() {
            return idsgar;
        }

        /**
         * Sets the value of the idsgar property.
         * 
         * @param value
         *     allowed object is
         *     {@link IDSGAR }
         *     
         */
        public void setIDSGAR(IDSGAR value) {
            this.idsgar = value;
        }

        /**
         * Gets the value of the idPref property.
         * 
         * @return
         *     possible object is
         *     {@link IDPref }
         *     
         */
        public IDPref getIDPref() {
            return idPref;
        }

        /**
         * Sets the value of the idPref property.
         * 
         * @param value
         *     allowed object is
         *     {@link IDPref }
         *     
         */
        public void setIDPref(IDPref value) {
            this.idPref = value;
        }

        /**
         * Gets the value of the idSousPref property.
         * 
         * @return
         *     possible object is
         *     {@link IDSousPref }
         *     
         */
        public IDSousPref getIDSousPref() {
            return idSousPref;
        }

        /**
         * Sets the value of the idSousPref property.
         * 
         * @param value
         *     allowed object is
         *     {@link IDSousPref }
         *     
         */
        public void setIDSousPref(IDSousPref value) {
            this.idSousPref = value;
        }

        /**
         * Gets the value of the referent property.
         * 
         * @return
         *     possible object is
         *     {@link Referent }
         *     
         */
        public Referent getReferent() {
            return referent;
        }

        /**
         * Sets the value of the referent property.
         * 
         * @param value
         *     allowed object is
         *     {@link Referent }
         *     
         */
        public void setReferent(Referent value) {
            this.referent = value;
        }

    }

}
