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
import fr.paris.lutece.util.ReferenceList;

import java.util.Collection;


/**
* IMatiereDAO Interface
*/
public interface IMatiereDAO
{
    /**
     * Insert a new record in the table.
     * @param matiere instance of the Matiere object to inssert
     * @param plugin the Plugin
     */
    void insert( Matiere matiere, Plugin plugin );

    /**
    * Update the record in the table
    * @param matiere the reference of the Matiere
    * @param plugin the Plugin
    */
    void store( Matiere matiere, Plugin plugin );

    /**
     * Delete a record from the table
     * @param strIdMatiere identifier of the Matiere to delete
     * @param plugin the Plugin
     */
    void delete( String strIdMatiere, Plugin plugin );

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Load the data from the table
     * @param strIdMatiere The identifier of the matiere
     * @param plugin the Plugin
     * @return The instance of the matiere
     */
    Matiere load( String strIdMatiere, Plugin plugin );

    /**
    * Load the data of all the matiere objects and returns them as a collection
    * @param plugin the Plugin
    * @return The collection which contains the data of all the matiere objects
    */
    Collection<Matiere> selectMatieresList( Plugin plugin );

    /**
     * Load the data of all the matieres and returns them as a ReferenceList
     * @param plugin The plugin
     * @return The ReferenceList which contains the data of all the matieres
     */
    ReferenceList getMatieresList( Plugin plugin );
}
