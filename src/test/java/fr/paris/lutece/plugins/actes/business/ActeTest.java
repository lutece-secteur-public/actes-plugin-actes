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
import fr.gouv.interieur.actes_v1.FichierSigne;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class ActeTest extends TestCase
{
    public void testGetXML(  )
    {
        Acte acte = new Acte(  );
        acte.setCodeNatureActe( new Integer( "1" ) );

        DonneesActe.CodeMatiere1 cm1 = new DonneesActe.CodeMatiere1(  );
        cm1.setCodeMatiere( new Integer( "2" ) );
        acte.setCodeMatiere1( cm1 );

        acte.setNumeroInterne( "546554564" );

        acte.setObjet( "objet" );

        FichierSigne fichier = new FichierSigne(  );
        fichier.setNomFichier( "hqdKLJHFq.pdf" );
        acte.setDocument( fichier );
        System.out.println( acte.getXML(  ) );
    }

    public void testGetDateString(  )
    {
        Acte acte = new Acte(  );
        Calendar calendar = new GregorianCalendar( 2007, 10, 18 );
        acte.setDate( calendar );
        System.out.println( acte.getDateDecision(  ) + "=" + "20071118" );
        assertEquals( acte.getDateDecision(  ), "20071118" );
    }
}
