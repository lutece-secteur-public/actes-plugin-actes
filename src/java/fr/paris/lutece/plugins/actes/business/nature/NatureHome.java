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
package fr.paris.lutece.plugins.actes.business.nature;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.util.ReferenceList;

import java.util.Collection;


/**
 * This class provides instances management methods (create, find, ...) for Nature objects
 */
public final class NatureHome
{
    private static final String PLUGIN_NAME = "actes";

    // Static variable pointed at the DAO instance
    private static INatureDAO _dao = (INatureDAO) SpringContextService.getPluginBean( "actes", "actes.natureDAO" );
    private static Plugin _plugin = PluginService.getPlugin( PLUGIN_NAME );

    /**
     * Private constructor - this class need not be instantiated
     */
    private NatureHome(  )
    {
    }

    /**
     * Create an instance of the nature class
     * @param nature The instance of the Nature which contains the informations to store
     * @return The  instance of nature which has been created with its primary key.
     */
    public static Nature create( Nature nature )
    {
        _dao.insert( nature, _plugin );

        return nature;
    }

    /**
     * Update of the nature which is specified in parameter
     * @param nature The instance of the Nature which contains the data to store
     * @return The instance of the  nature which has been updated
     */
    public static Nature update( Nature nature )
    {
        _dao.store( nature, _plugin );

        return nature;
    }

    /**
     * Remove the nature whose identifier is specified in parameter
     * @param nNatureId The nature Id
     */
    public static void remove( int nNatureId )
    {
        _dao.delete( nNatureId, _plugin );
    }

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Returns an instance of a nature whose identifier is specified in parameter
     * @param nKey The nature primary key
     * @return an instance of Nature
     */
    public static Nature findByPrimaryKey( int nKey )
    {
        return _dao.load( nKey, _plugin );
    }

    /**
     * Load the data of all the nature objects and returns them in form of a collection
     * @return the collection which contains the data of all the nature objects
     */
    public static Collection<Nature> getNaturesList(  )
    {
        return _dao.selectNaturesList( _plugin );
    }

    /**
     * Load the data of all the natures and returns them as a reference list
     * @return The reference list which contains the data of all the natures
     */
    public static ReferenceList getNaturesReferenceList(  )
    {
        return _dao.getNaturesList( _plugin );
    }
}
