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
import fr.paris.lutece.util.ReferenceList;

import java.util.Collection;


/**
 * INatureDAO Interface
 */
public interface INatureDAO
{
    /**
     * Insert a new record in the table.
     * @param nature instance of the Nature object to inssert
     * @param plugin the Plugin
     */
    void insert( Nature nature, Plugin plugin );

    /**
     * Update the record in the table
     * @param nature the reference of the Nature
     * @param plugin the Plugin
     */
    void store( Nature nature, Plugin plugin );

    /**
     * Delete a record from the table
     * @param nIdNature int identifier of the Nature to delete
     * @param plugin the Plugin
     */
    void delete( int nIdNature, Plugin plugin );

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Load the data from the table
     * @param nKey The identifier of the nature
     * @param plugin the Plugin
     * @return The instance of the nature
     */
    Nature load( int nKey, Plugin plugin );

    /**
     * Load the data of all the nature objects and returns them as a collection
     * @param plugin the Plugin
     * @return The collection which contains the data of all the nature objects
     */
    Collection<Nature> selectNaturesList( Plugin plugin );

    /**
     * Load the data of all the natures and returns them as a reference list
     * @param plugin The plugin
     * @return The reference list which contains the data of all the natures
     */
    ReferenceList getNaturesList( Plugin plugin );
}
