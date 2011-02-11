/*
 * Copyright (c) 2002-2009, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.actes.business;

import fr.gouv.interieur.actes_v1.DonneesActe;
import fr.gouv.interieur.actes_v1.ObjectFactory;

import fr.paris.lutece.plugins.actes.util.ActeNamespacePrefixMapper;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;

import java.io.StringWriter;

import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * Classe Acte.<br />
 * This class inherits the DonnesActe produced by JAXB from the Actes XML schema.
 */
public class Acte extends DonneesActe
{
    private static final String XML_ENCODING = "actes.xml.encoding";
    private static final String XML_ENCODING_DEFAULT = "ISO-8859-1";
    
    
    /**
     * Produce an XML document compliant with the ACTES XML schema (actes.xsd)
     * @return The XML document
     */
    public String getXML(  )
    {
        StringWriter sw = new StringWriter(  );
        String strXmlEncoding = AppPropertiesService.getProperty( XML_ENCODING, XML_ENCODING_DEFAULT);

        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance( "fr.gouv.interieur.actes_v1" );
            ObjectFactory factory = new ObjectFactory(  );
            Marshaller marshaller = jaxbContext.createMarshaller(  );
            marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            marshaller.setProperty( "com.sun.xml.bind.namespacePrefixMapper", new ActeNamespacePrefixMapper(  ) );
            marshaller.setProperty( Marshaller.JAXB_ENCODING, strXmlEncoding );
            marshaller.marshal( factory.createActe( this ), sw );
        }
        catch ( JAXBException e )
        {
            AppLogService.error( "Error marshalling Actes document : " + e.getMessage(  ), e );
        }

        return sw.toString(  );
    }

    /**
     * Renvoie la date de decision au format "YYYYMMDD"
     * @return la date de decision
     */
    public String getDateDecision(  )
    {
        Calendar calendar = this.getDate(  );
        String strDate = String.format( "%1$04d%2$02d%3$02d", calendar.get( Calendar.YEAR ),
                calendar.get( Calendar.MONTH ) + 1, calendar.get( Calendar.DAY_OF_MONTH ) );

        return strDate;
    }

    /**
     * Renvoie la date de la version de classification au format "YYYYMMDD"
     * @return la date de la version de classification
     */
    public String getDateClassification(  )
    {
        Calendar calendar = this.getClassificationDateVersion(  );
        String strDate = String.format( "%1$04d%2$02d%3$02d", calendar.get( Calendar.YEAR ),
                calendar.get( Calendar.MONTH ) + 1, calendar.get( Calendar.DAY_OF_MONTH ) );

        return strDate;
    }
}
