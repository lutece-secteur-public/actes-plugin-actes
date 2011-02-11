//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.11.15 at 01:18:12 AM CET 
//


package fr.gouv.interieur.actes_v1;

import java.math.BigInteger;
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
 *         &lt;element name="DateClassification" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="NaturesActes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="NatureActe">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}CodeNatureActe"/>
 *                           &lt;attribute name="Libelle" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="TypeAbrege" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;length value="2"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Matieres">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="Matiere1">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="Matiere2">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
 *                                     &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                                       &lt;element name="Matiere3">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
 *                                               &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                                                 &lt;element name="Matiere4">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
 *                                                         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                                                           &lt;element name="Matiere5" type="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/extension>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/extension>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
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
    "dateClassification",
    "naturesActes",
    "matieres"
})
@XmlRootElement(name = "RetourClassification")
public class RetourClassification {

    @XmlElement(name = "DateClassification", required = true)
    protected XMLGregorianCalendar dateClassification;
    @XmlElement(name = "NaturesActes", required = true)
    protected RetourClassification.NaturesActes naturesActes;
    @XmlElement(name = "Matieres", required = true)
    protected RetourClassification.Matieres matieres;

    /**
     * Gets the value of the dateClassification property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateClassification() {
        return dateClassification;
    }

    /**
     * Sets the value of the dateClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateClassification(XMLGregorianCalendar value) {
        this.dateClassification = value;
    }

    /**
     * Gets the value of the naturesActes property.
     * 
     * @return
     *     possible object is
     *     {@link RetourClassification.NaturesActes }
     *     
     */
    public RetourClassification.NaturesActes getNaturesActes() {
        return naturesActes;
    }

    /**
     * Sets the value of the naturesActes property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetourClassification.NaturesActes }
     *     
     */
    public void setNaturesActes(RetourClassification.NaturesActes value) {
        this.naturesActes = value;
    }

    /**
     * Gets the value of the matieres property.
     * 
     * @return
     *     possible object is
     *     {@link RetourClassification.Matieres }
     *     
     */
    public RetourClassification.Matieres getMatieres() {
        return matieres;
    }

    /**
     * Sets the value of the matieres property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetourClassification.Matieres }
     *     
     */
    public void setMatieres(RetourClassification.Matieres value) {
        this.matieres = value;
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
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="Matiere1">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
     *                 &lt;sequence maxOccurs="unbounded">
     *                   &lt;element name="Matiere2">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
     *                           &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *                             &lt;element name="Matiere3">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
     *                                     &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *                                       &lt;element name="Matiere4">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
     *                                               &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *                                                 &lt;element name="Matiere5" type="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere"/>
     *                                               &lt;/sequence>
     *                                             &lt;/extension>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/extension>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/extension>
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
        "matiere1"
    })
    public static class Matieres {

        @XmlElement(name = "Matiere1", required = true)
        protected List<RetourClassification.Matieres.Matiere1> matiere1;

        /**
         * Gets the value of the matiere1 property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the matiere1 property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMatiere1().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RetourClassification.Matieres.Matiere1 }
         * 
         * 
         */
        public List<RetourClassification.Matieres.Matiere1> getMatiere1() {
            if (matiere1 == null) {
                matiere1 = new ArrayList<RetourClassification.Matieres.Matiere1>();
            }
            return this.matiere1;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
         *       &lt;sequence maxOccurs="unbounded">
         *         &lt;element name="Matiere2">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
         *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
         *                   &lt;element name="Matiere3">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
         *                           &lt;sequence maxOccurs="unbounded" minOccurs="0">
         *                             &lt;element name="Matiere4">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
         *                                     &lt;sequence maxOccurs="unbounded" minOccurs="0">
         *                                       &lt;element name="Matiere5" type="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere"/>
         *                                     &lt;/sequence>
         *                                   &lt;/extension>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/extension>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "matiere2"
        })
        public static class Matiere1
            extends Matiere
        {

            @XmlElement(name = "Matiere2", required = true)
            protected List<RetourClassification.Matieres.Matiere1 .Matiere2> matiere2;

            /**
             * Gets the value of the matiere2 property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the matiere2 property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getMatiere2().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link RetourClassification.Matieres.Matiere1 .Matiere2 }
             * 
             * 
             */
            public List<RetourClassification.Matieres.Matiere1 .Matiere2> getMatiere2() {
                if (matiere2 == null) {
                    matiere2 = new ArrayList<RetourClassification.Matieres.Matiere1 .Matiere2>();
                }
                return this.matiere2;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
             *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
             *         &lt;element name="Matiere3">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
             *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
             *                   &lt;element name="Matiere4">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
             *                           &lt;sequence maxOccurs="unbounded" minOccurs="0">
             *                             &lt;element name="Matiere5" type="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere"/>
             *                           &lt;/sequence>
             *                         &lt;/extension>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
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
                "matiere3"
            })
            public static class Matiere2
                extends Matiere
            {

                @XmlElement(name = "Matiere3")
                protected List<RetourClassification.Matieres.Matiere1 .Matiere2 .Matiere3> matiere3;

                /**
                 * Gets the value of the matiere3 property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the matiere3 property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getMatiere3().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link RetourClassification.Matieres.Matiere1 .Matiere2 .Matiere3 }
                 * 
                 * 
                 */
                public List<RetourClassification.Matieres.Matiere1 .Matiere2 .Matiere3> getMatiere3() {
                    if (matiere3 == null) {
                        matiere3 = new ArrayList<RetourClassification.Matieres.Matiere1 .Matiere2 .Matiere3>();
                    }
                    return this.matiere3;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
                 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
                 *         &lt;element name="Matiere4">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
                 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
                 *                   &lt;element name="Matiere5" type="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere"/>
                 *                 &lt;/sequence>
                 *               &lt;/extension>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
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
                    "matiere4"
                })
                public static class Matiere3
                    extends Matiere
                {

                    @XmlElement(name = "Matiere4")
                    protected List<RetourClassification.Matieres.Matiere1 .Matiere2 .Matiere3 .Matiere4> matiere4;

                    /**
                     * Gets the value of the matiere4 property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the matiere4 property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getMatiere4().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link RetourClassification.Matieres.Matiere1 .Matiere2 .Matiere3 .Matiere4 }
                     * 
                     * 
                     */
                    public List<RetourClassification.Matieres.Matiere1 .Matiere2 .Matiere3 .Matiere4> getMatiere4() {
                        if (matiere4 == null) {
                            matiere4 = new ArrayList<RetourClassification.Matieres.Matiere1 .Matiere2 .Matiere3 .Matiere4>();
                        }
                        return this.matiere4;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;extension base="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere">
                     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
                     *         &lt;element name="Matiere5" type="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}Matiere"/>
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
                        "matiere5"
                    })
                    public static class Matiere4
                        extends Matiere
                    {

                        @XmlElement(name = "Matiere5")
                        protected List<Matiere> matiere5;

                        /**
                         * Gets the value of the matiere5 property.
                         * 
                         * <p>
                         * This accessor method returns a reference to the live list,
                         * not a snapshot. Therefore any modification you make to the
                         * returned list will be present inside the JAXB object.
                         * This is why there is not a <CODE>set</CODE> method for the matiere5 property.
                         * 
                         * <p>
                         * For example, to add a new item, do as follows:
                         * <pre>
                         *    getMatiere5().add(newItem);
                         * </pre>
                         * 
                         * 
                         * <p>
                         * Objects of the following type(s) are allowed in the list
                         * {@link Matiere }
                         * 
                         * 
                         */
                        public List<Matiere> getMatiere5() {
                            if (matiere5 == null) {
                                matiere5 = new ArrayList<Matiere>();
                            }
                            return this.matiere5;
                        }

                    }

                }

            }

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
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="NatureActe">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}CodeNatureActe"/>
     *                 &lt;attribute name="Libelle" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="TypeAbrege" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;length value="2"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
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
        "natureActe"
    })
    public static class NaturesActes {

        @XmlElement(name = "NatureActe", required = true)
        protected List<RetourClassification.NaturesActes.NatureActe> natureActe;

        /**
         * Gets the value of the natureActe property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the natureActe property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNatureActe().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RetourClassification.NaturesActes.NatureActe }
         * 
         * 
         */
        public List<RetourClassification.NaturesActes.NatureActe> getNatureActe() {
            if (natureActe == null) {
                natureActe = new ArrayList<RetourClassification.NaturesActes.NatureActe>();
            }
            return this.natureActe;
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
         *       &lt;attribute ref="{http://www.interieur.gouv.fr/ACTES#v1.1-20040216}CodeNatureActe"/>
         *       &lt;attribute name="Libelle" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="TypeAbrege" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;length value="2"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class NatureActe {

            @XmlAttribute(name = "CodeNatureActe", namespace = "http://www.interieur.gouv.fr/ACTES#v1.1-20040216")
            protected BigInteger codeNatureActe;
            @XmlAttribute(name = "Libelle", namespace = "http://www.interieur.gouv.fr/ACTES#v1.1-20040216", required = true)
            protected String libelle;
            @XmlAttribute(name = "TypeAbrege", namespace = "http://www.interieur.gouv.fr/ACTES#v1.1-20040216", required = true)
            protected String typeAbrege;

            /**
             * Gets the value of the codeNatureActe property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getCodeNatureActe() {
                return codeNatureActe;
            }

            /**
             * Sets the value of the codeNatureActe property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setCodeNatureActe(BigInteger value) {
                this.codeNatureActe = value;
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

            /**
             * Gets the value of the typeAbrege property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTypeAbrege() {
                return typeAbrege;
            }

            /**
             * Sets the value of the typeAbrege property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTypeAbrege(String value) {
                this.typeAbrege = value;
            }

        }

    }

}
