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

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.util.ReferenceList;

import java.util.Collection;


/**
 * This class provides instances management methods (create, find, ...) for Matiere objects
 */
public final class MatiereHome
{
    private static final String PLUGIN_NAME = "actes";

    // Static variable pointed at the DAO instance
    private static IMatiereDAO _dao = (IMatiereDAO) SpringContextService.getPluginBean( PLUGIN_NAME, "actes.matiereDAO" );
    private static Plugin _plugin = PluginService.getPlugin( PLUGIN_NAME );

    /**
     * Private constructor - this class need not be instantiated
     */
    private MatiereHome(  )
    {
    }

    /**
     * Create an instance of the matiere class
     * @param matiere The instance of the Matiere which contains the informations to store
     * @return The  instance of matiere which has been created with its primary key.
     */
    public static Matiere create( Matiere matiere )
    {
        _dao.insert( matiere, _plugin );

        return matiere;
    }

    /**
     * Update of the matiere which is specified in parameter
     * @param matiere The instance of the Matiere which contains the data to store
     * @return The instance of the  matiere which has been updated
     */
    public static Matiere update( Matiere matiere )
    {
        _dao.store( matiere, _plugin );

        return matiere;
    }

    /**
     * Remove the matiere whose identifier is specified in parameter
     * @param strIdMatiere The matiere Id
     */
    public static void remove( String strIdMatiere )
    {
        _dao.delete( strIdMatiere, _plugin );
    }

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Returns an instance of a matiere whose identifier is specified in parameter
     * @param strKey The matiere primary key
     * @return an instance of Matiere
     */
    public static Matiere findByPrimaryKey( String strKey )
    {
        return _dao.load( strKey, _plugin );
    }

    /**
     * Load the data of all the matiere objects and returns them in form of a collection
     * @return the collection which contains the data of all the matiere objects
     */
    public static Collection<Matiere> getMatieresList(  )
    {
        return _dao.selectMatieresList( _plugin );
    }

    /**
     * Load the data of all the matiere objects and returns them in form of a collection
     * @return the collection which contains the data of all the matiere objects
     */
    public static ReferenceList getMatieresReferenceList(  )
    {
        return _dao.getMatieresList( _plugin );
    }
}
