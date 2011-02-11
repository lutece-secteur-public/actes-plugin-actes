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
package fr.paris.lutece.plugins.actes.business.transaction;


/**
 * This is the business class for the object Transaction
 */
public class Transaction
{
    public static final int STATUS_ERROR = -1;
    public static final int STATUS_ANNULE = 0;
    public static final int STATUS_POSTE = 1;
    public static final int STATUS_EN_ATTENTE = 2;
    public static final int STATUS_TRANSMIS = 3;
    public static final int STATUS_ACQUITE = 4;
    public static final int STATUS_VALIDE = 5;
    public static final int STATUS_REFUSE = 6;

    // Variables declarations
    private int _nId;
    private String _strCode;
    private String _strNature;
    private String _strClassification;
    private String _strDateDecision;
    private String _strNumeroInterne;
    private String _strObjet;
    private int _nStatus;

    /**
     * Returns the Transaction Id
     * @return The Transaction Id
     */
    public int getId(  )
    {
        return _nId;
    }

    /**
     * Sets the Transaction Id
     * @param nId The Transaction Id
     */
    public void setId( int nId )
    {
        _nId = nId;
    }

    /**
     * Returns the Transaction Code
     * @return The Transaction Code
     */
    public String getCode(  )
    {
        return _strCode;
    }

    /**
     * Sets the Transaction Code
     * @param strCode The Transaction Code
     */
    public void setCode( String strCode )
    {
        _strCode = strCode;
    }

    /**
     * Returns the Nature
     * @return The Nature
     */
    public String getNature(  )
    {
        return _strNature;
    }

    /**
     * Sets the Nature
     * @param strNature The Nature
     */
    public void setNature( String strNature )
    {
        _strNature = strNature;
    }

    /**
     * Returns the Classification
     * @return The Classification
     */
    public String getClassification(  )
    {
        return _strClassification;
    }

    /**
     * Sets the Classification
     * @param strClassification The Classification
     */
    public void setClassification( String strClassification )
    {
        _strClassification = strClassification;
    }

    /**
     * Returns the DateDecision
     * @return The DateDecision
     */
    public String getDateDecision(  )
    {
        return _strDateDecision;
    }

    /**
     * Sets the DateDecision
     * @param strDateDecision The DateDecision
     */
    public void setDateDecision( String strDateDecision )
    {
        _strDateDecision = strDateDecision;
    }

    /**
     * Returns the NumeroInterne
     * @return The NumeroInterne
     */
    public String getNumeroInterne(  )
    {
        return _strNumeroInterne;
    }

    /**
     * Sets the NumeroInterne
     * @param strNumeroInterne The NumeroInterne
     */
    public void setNumeroInterne( String strNumeroInterne )
    {
        _strNumeroInterne = strNumeroInterne;
    }

    /**
     * Returns the Objet
     * @return The Objet
     */
    public String getObjet(  )
    {
        return _strObjet;
    }

    /**
     * Sets the Objet
     * @param strObjet The Objet
     */
    public void setObjet( String strObjet )
    {
        _strObjet = strObjet;
    }

    /**
     * Returns the Status
     * @return The Status
     */
    public int getStatus(  )
    {
        return _nStatus;
    }

    /**
     * Sets the Status
     * @param nStatus The Status
     */
    public void setStatus( int nStatus )
    {
        _nStatus = nStatus;
    }
}
