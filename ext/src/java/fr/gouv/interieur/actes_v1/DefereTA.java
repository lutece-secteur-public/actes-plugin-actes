//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.11.15 at 01:18:12 AM CET 
//


package fr.gouv.interieur.actes_v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="DateDepot" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="NatureIllegalite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PiecesJointes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="PieceJointe" type="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}FichierSigne"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}IDActe use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dateDepot",
    "natureIllegalite",
    "piecesJointes"
})
@XmlRootElement(name = "DefereTA")
public class DefereTA {

    @XmlElement(name = "DateDepot", required = true)
    protected XMLGregorianCalendar dateDepot;
    @XmlElement(name = "NatureIllegalite", required = true)
    protected String natureIllegalite;
    @XmlElement(name = "PiecesJointes", required = true)
    protected DefereTA.PiecesJointes piecesJointes;
    @XmlAttribute(name = "IDActe", namespace = "http://www.interieur.gouv.fr/ACTES#v1.1-20040216", required = true)
    protected String idActe;

    /**
     * Gets the value of the dateDepot property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDepot() {
        return dateDepot;
    }

    /**
     * Sets the value of the dateDepot property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDepot(XMLGregorianCalendar value) {
        this.dateDepot = value;
    }

    /**
     * Gets the value of the natureIllegalite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNatureIllegalite() {
        return natureIllegalite;
    }

    /**
     * Sets the value of the natureIllegalite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNatureIllegalite(String value) {
        this.natureIllegalite = value;
    }

    /**
     * Gets the value of the piecesJointes property.
     * 
     * @return
     *     possible object is
     *     {@link DefereTA.PiecesJointes }
     *     
     */
    public DefereTA.PiecesJointes getPiecesJointes() {
        return piecesJointes;
    }

    /**
     * Sets the value of the piecesJointes property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefereTA.PiecesJointes }
     *     
     */
    public void setPiecesJointes(DefereTA.PiecesJointes value) {
        this.piecesJointes = value;
    }

    /**
     * Gets the value of the idActe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDActe() {
        return idActe;
    }

    /**
     * Sets the value of the idActe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDActe(String value) {
        this.idActe = value;
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
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="PieceJointe" type="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}FichierSigne"/>
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
        "pieceJointe"
    })
    public static class PiecesJointes {

        @XmlElement(name = "PieceJointe")
        protected List<FichierSigne> pieceJointe;

        /**
         * Gets the value of the pieceJointe property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the pieceJointe property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPieceJointe().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FichierSigne }
         * 
         * 
         */
        public List<FichierSigne> getPieceJointe() {
            if (pieceJointe == null) {
                pieceJointe = new ArrayList<FichierSigne>();
            }
            return this.pieceJointe;
        }

    }

}
