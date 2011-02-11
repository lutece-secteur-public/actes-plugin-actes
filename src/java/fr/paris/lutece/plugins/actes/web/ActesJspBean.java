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
package fr.paris.lutece.plugins.actes.web;

import fr.gouv.interieur.actes_v1.DonneesActe;
import fr.gouv.interieur.actes_v1.DonneesActe.Annexes;
import fr.gouv.interieur.actes_v1.FichierSigne;

import fr.paris.lutece.plugins.actes.business.Acte;
import fr.paris.lutece.plugins.actes.business.matieres.MatiereHome;
import fr.paris.lutece.plugins.actes.business.nature.NatureHome;
import fr.paris.lutece.plugins.actes.business.transaction.Transaction;
import fr.paris.lutece.plugins.actes.business.transaction.TransactionHome;
import fr.paris.lutece.plugins.actes.service.ActesService;
import fr.paris.lutece.plugins.actes.service.TransmissionException;
import fr.paris.lutece.portal.service.message.AdminMessage;
import fr.paris.lutece.portal.service.message.AdminMessageService;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.web.admin.PluginAdminPageJspBean;
import fr.paris.lutece.portal.web.upload.MultipartHttpServletRequest;
import fr.paris.lutece.util.ReferenceList;
import fr.paris.lutece.util.date.DateUtil;
import fr.paris.lutece.util.html.HtmlTemplate;

import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;


/**
 * Actes Jsp Bean
 */
public class ActesJspBean extends PluginAdminPageJspBean
{
    // Right
    public static final String RIGHT_MANAGE_ACTES = "ACTES_MANAGEMENT";

    //Templates
    private static final String TEMPLATE_MANAGE_ACTES = "admin/plugins/actes/manage_actes.html";
    private static final String TEMPLATE_CREATE_ACTE = "admin/plugins/actes/create_acte.html";
    private static final String TEMPLATE_VIEW_ACTES = "admin/plugins/actes/view_actes.html";

    // Boomarks
    private static final String MARK_NATURES = "natures_list";
    private static final String MARK_MATIERES = "matieres_list";
    private static final String MARK_LOCALE = "locale";
    private static final String MARK_TRANSACTIONS_LIST = "transactions_list";
    private static final String PARAMETER_NATURE = "nature";
    private static final String PARAMETER_CLASSIFICATION = "classification";
    private static final String PARAMETER_NUMERO = "numero";
    private static final String PARAMETER_DATE_DECISION = "date_decision";
    private static final String PARAMETER_OBJET = "objet";
    private static final String PARAMETER_FICHIER_PDF = "fichier_pdf";
    private static final String PARAMETER_FICHIER_JOINT = "fichier_joint_";
    private static final String TEMP_FILE_PREFIX = "actes-";

    // Messages keys
    private static final String MESSAGE_KEY_SELECT_NATURE = "actes.message.selectNature";
    private static final String MESSAGE_KEY_TRANSMISSION_ERROR = "actes.message.transmissionError";
    private static final String MESSAGE_KEY_DATE_FORMAT_ERROR = "actes.message.dateFormatError";
    private static final String MESSAGE_KEY_FILE_TEMP_ERROR = "actes.message.tempFileError";
    private static final String MESSAGE_KEY_TRANSMISSION_SUCCEED = "actes.message.transmissionSucceed";
    private List<File> _listTempFiles = new ArrayList<File>(  );

    /**
     * Returns the manage actes page
     * @param request The HTTP request
     * @return The HTML page
     */
    public String manageActes( HttpServletRequest request )
    {
        Map<String, Object> model = new HashMap<String, Object>(  );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_MANAGE_ACTES, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Returns the create acte page
     * @param request The HTTP request
     * @return The HTML page
     */
    public String getCreateActe( HttpServletRequest request )
    {
        Map<String, Object> model = new HashMap<String, Object>(  );

        ReferenceList listNatures = NatureHome.getNaturesReferenceList(  );
        ReferenceList listMatieres = MatiereHome.getMatieresReferenceList(  );

        model.put( MARK_NATURES, listNatures );
        model.put( MARK_MATIERES, listMatieres );
        model.put( MARK_LOCALE, getLocale(  ) ); // required by Datepicker

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_CREATE_ACTE, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Returns the view actes page
     * @param request The HTTP request
     * @return The HTML page
     */
    public String viewActes( HttpServletRequest request )
    {
        Map<String, Object> model = new HashMap<String, Object>(  );

        Collection<Transaction> listTransactions = TransactionHome.getTransactionsList(  );

        try
        {
            // Update transaction status
            for ( Transaction transaction : listTransactions )
            {
                ActesService.getInstance(  ).getTransmissionService(  ).getInfos( transaction );
            }
        }
        catch ( TransmissionException e )
        {
            AppLogService.error( "Erreur : " + e.getMessage(  ), e );
        }

        model.put( MARK_TRANSACTIONS_LIST, listTransactions );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_VIEW_ACTES, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Create a new Acte
     * @param request The HTTP request
     * @return The forward URL
     */
    public String doCreateActe( HttpServletRequest request )
    {
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;

        Acte acte = new Acte(  );

        try
        {
            setNature( mRequest, acte );
            setClassification( mRequest, acte );
            setNumeroInterne( mRequest, acte );
            setDateDecision( mRequest, acte );
            setObjet( mRequest, acte );
            setDocument( mRequest, acte );
            setAttachments( mRequest, acte );
        }
        catch ( ActesCreateFormException e )
        {
            return getErrorPage( mRequest, e );
        }

        // The acte is filled with form data and is ready to be send
        try
        {
            // Debug logging
            //            AppLogService.info( acte.getXML(  ) );
            String strTransactionId = ActesService.getInstance(  ).getTransmissionService(  ).sendActe( acte );

            // transmission succeed, so store the new transaction
            Transaction transaction = new Transaction(  );
            transaction.setCode( strTransactionId );
            transaction.setStatus( Transaction.STATUS_POSTE );
            transaction.setNumeroInterne( acte.getNumeroInterne(  ) );
            transaction.setObjet( acte.getObjet(  ) );
            TransactionHome.create( transaction );
        }
        catch ( TransmissionException e )
        {
            Object[] args = { e.getMessage(  ) };

            return AdminMessageService.getMessageUrl( request, MESSAGE_KEY_TRANSMISSION_ERROR, args,
                AdminMessage.TYPE_STOP );
        }
        finally
        {
            // Remove temporary files after the transmission
            for ( File temp : _listTempFiles )
            {
                if ( ( temp != null ) && ( temp.exists(  ) ) )
                {
                    temp.delete(  );
                }
            }
        }

        return AdminMessageService.getMessageUrl( request, MESSAGE_KEY_TRANSMISSION_SUCCEED, getHomeUrl( request ),
            AdminMessage.TYPE_INFO );
    }

    /**
     * Sets the nature of the Acte
     * @param mRequest The multipart request
     * @param acte The acte to fill with request data
     * @throws ActesCreateFormException error during acte creation
     */
    private void setNature( MultipartHttpServletRequest mRequest, Acte acte )
        throws ActesCreateFormException
    {
        String strNature = mRequest.getParameter( PARAMETER_NATURE );
        int nNature;

        try
        {
            nNature = Integer.parseInt( strNature );
        }
        catch ( NumberFormatException ex )
        {
            throw new ActesCreateFormException( MESSAGE_KEY_SELECT_NATURE );
        }

        if ( nNature == -1 )
        {
            throw new ActesCreateFormException( MESSAGE_KEY_SELECT_NATURE );
        }

        acte.setCodeNatureActe( new Integer( strNature ) );
    }

    /**
     * Sets the classification of the Acte
     * @param mRequest The multipart request
     * @param acte The acte to fill with request data
     * @throws ActesCreateFormException error during acte creation
     */
    private void setClassification( MultipartHttpServletRequest mRequest, Acte acte )
        throws ActesCreateFormException
    {
        String strClassification = mRequest.getParameter( PARAMETER_CLASSIFICATION );
        StringTokenizer st = new StringTokenizer( strClassification, "." );
        ArrayList<String> listMatieres = new ArrayList<String>(  );

        while ( st.hasMoreTokens(  ) )
        {
            listMatieres.add( st.nextToken(  ) );
        }

        if ( listMatieres.size(  ) > 0 )
        {
            DonneesActe.CodeMatiere1 cm1 = new DonneesActe.CodeMatiere1(  );
            cm1.setCodeMatiere( new Integer( listMatieres.get( 0 ) ) );
            acte.setCodeMatiere1( cm1 );
        }

        if ( listMatieres.size(  ) > 1 )
        {
            DonneesActe.CodeMatiere2 cm2 = new DonneesActe.CodeMatiere2(  );
            cm2.setCodeMatiere( new Integer( listMatieres.get( 1 ) ) );
            acte.setCodeMatiere2( cm2 );
        }
    }

    /**
     * Sets the numero interne of the Acte
     * @param mRequest The multipart request
     * @param acte The acte to fill with request data
     */
    private void setNumeroInterne( MultipartHttpServletRequest mRequest, Acte acte )
    {
        String strNumero = mRequest.getParameter( PARAMETER_NUMERO );
        acte.setNumeroInterne( strNumero );
    }

    /**
     * Sets the date de decision of the Acte
     * @param mRequest The multipart request
     * @param acte The acte to fill with request data
     * @throws ActesCreateFormException error during acte creation
     */
    private void setDateDecision( MultipartHttpServletRequest mRequest, Acte acte )
        throws ActesCreateFormException
    {
        String strDateDecision = mRequest.getParameter( PARAMETER_DATE_DECISION );
        Date dateDecision = DateUtil.formatDateSql( strDateDecision, getLocale(  ) );

        if ( dateDecision == null )
        {
            throw new ActesCreateFormException( MESSAGE_KEY_DATE_FORMAT_ERROR );
        }

        GregorianCalendar calDecision = new GregorianCalendar(  );
        calDecision.setTime( dateDecision );
        acte.setDate( calDecision );
    }

    /**
     * Sets the object of the Acte
     * @param mRequest The multipart request
     * @param acte The acte to fill with request data
     */
    private void setObjet( MultipartHttpServletRequest mRequest, Acte acte )
    {
        String strObjet = mRequest.getParameter( PARAMETER_OBJET );
        acte.setObjet( strObjet );
    }

    /**
     * Sets the document of the Acte
     * @param mRequest The multipart request
     * @param acte The acte to fill with request data
     * @throws ActesCreateFormException error during acte creation
     */
    private void setDocument( MultipartHttpServletRequest mRequest, Acte acte )
        throws ActesCreateFormException
    {
        FileItem filePDF = mRequest.getFile( PARAMETER_FICHIER_PDF );
        File fileTemp = null;

        try
        {
            fileTemp = getTempFile( getFileExtension( filePDF ) );
            filePDF.write( fileTemp );
        }
        catch ( Exception e )
        {
            if ( ( fileTemp != null ) && ( fileTemp.exists(  ) ) )
            {
                fileTemp.delete(  );
            }

            Object[] args = { e.getMessage(  ) };
            throw new ActesCreateFormException( MESSAGE_KEY_FILE_TEMP_ERROR, args );
        }

        // Store the file path into the acte data
        FichierSigne fichier = new FichierSigne(  );
        fichier.setNomFichier( fileTemp.getPath(  ) );
        acte.setDocument( fichier );
    }

    /**
     * Sets attachements of the Acte
     * @param mRequest The multipart request
     * @param acte The acte to fill with request data
     * @throws ActesCreateFormException error during acte creation
     */
    private void setAttachments( MultipartHttpServletRequest mRequest, Acte acte )
        throws ActesCreateFormException
    {
        int nAttachmentCount = 1;
        FileItem file = mRequest.getFile( PARAMETER_FICHIER_JOINT + nAttachmentCount );

        Annexes annexes = new Annexes(  );

        while ( file != null )
        {
            File fileTemp = null;

            try
            {
                fileTemp = getTempFile( getFileExtension( file ) );
                file.write( fileTemp );
            }
            catch ( Exception e )
            {
                if ( ( fileTemp != null ) && ( fileTemp.exists(  ) ) )
                {
                    fileTemp.delete(  );
                }

                Object[] args = { e.getMessage(  ) };
                throw new ActesCreateFormException( MESSAGE_KEY_FILE_TEMP_ERROR, args );
            }

            // Store the file path into the acte data
            FichierSigne fichier = new FichierSigne(  );
            fichier.setNomFichier( fileTemp.getPath(  ) );
            annexes.getAnnexe(  ).add( fichier );

            // Try to read the next attachment
            nAttachmentCount++;
            file = mRequest.getFile( PARAMETER_FICHIER_JOINT + nAttachmentCount );
        }

        acte.setAnnexes( annexes );
    }

    /**
     * Return a temporary file
     * @param strSuffix the suffix
     * @return file the temporary file
     * @throws IOException error during creation of the file
     */
    private File getTempFile( String strSuffix ) throws IOException
    {
        File file = File.createTempFile( TEMP_FILE_PREFIX, strSuffix );
        _listTempFiles.add( file );

        return file;
    }

    /**
     * Return the file extension
     * @param file the file
     * @return String the extension
     */
    private String getFileExtension( FileItem file )
    {
        return file.getName(  ).substring( file.getName(  ).lastIndexOf( "." ) );
    }

    /**
     * Return the error page url
     * @param request the HttpServletRequest object
     * @param e the exception
     * @return String the url
     */
    private String getErrorPage( HttpServletRequest request, ActesCreateFormException e )
    {
        String strErrorPageUrl = AdminMessageService.getMessageUrl( request, e.getErrorKey(  ), AdminMessage.TYPE_STOP );

        if ( e.getArgs(  ) != null )
        {
            strErrorPageUrl = AdminMessageService.getMessageUrl( request, e.getErrorKey(  ), e.getArgs(  ),
                    AdminMessage.TYPE_STOP );
        }

        return strErrorPageUrl;
    }
}
