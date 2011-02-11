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
package fr.paris.lutece.plugins.actes.business.matieres;

import fr.paris.lutece.test.LuteceTestCase;


public class MatiereBusinessTest extends LuteceTestCase
{
    private final static String CODEMATIERE1 = "11.1";
    private final static String CODEMATIERE2 = "11.2";
    private final static String LIBELLEMATIERE1 = "LibelleMatiere1";
    private final static String LIBELLEMATIERE2 = "LibelleMatiere2";

    public void testBusiness(  )
    {
        // Initialize an object
        Matiere matiere = new Matiere(  );
        matiere.setCodeMatiere( CODEMATIERE1 );
        matiere.setLibelleMatiere( LIBELLEMATIERE1 );

        // Create test
        MatiereHome.create( matiere );

        Matiere matiereStored = MatiereHome.findByPrimaryKey( matiere.getCodeMatiere(  ) );
        assertEquals( matiereStored.getCodeMatiere(  ), matiere.getCodeMatiere(  ) );
        assertEquals( matiereStored.getLibelleMatiere(  ), matiere.getLibelleMatiere(  ) );

        // Update test
        matiere.setCodeMatiere( CODEMATIERE2 );
        matiere.setLibelleMatiere( LIBELLEMATIERE2 );
        MatiereHome.update( matiere );
        matiereStored = MatiereHome.findByPrimaryKey( matiere.getCodeMatiere(  ) );
        assertEquals( matiereStored.getCodeMatiere(  ), matiere.getCodeMatiere(  ) );
        assertEquals( matiereStored.getLibelleMatiere(  ), matiere.getLibelleMatiere(  ) );

        // List test
        MatiereHome.getMatieresList(  );

        // Delete test
        MatiereHome.remove( matiere.getCodeMatiere(  ) );
        matiereStored = MatiereHome.findByPrimaryKey( matiere.getCodeMatiere(  ) );
        assertNull( matiereStored );
    }
}
