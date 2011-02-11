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
import fr.paris.lutece.util.sql.DAOUtil;

import java.util.ArrayList;
import java.util.Collection;


/**
 * This class provides Data Access methods for Matiere objects
 */
public final class MatiereDAO implements IMatiereDAO
{
    // Constants
    private static final String SQL_QUERY_SELECT = "SELECT code_matiere, libelle_matiere FROM actes_matieres WHERE code_matiere = ?";
    private static final String SQL_QUERY_INSERT = "INSERT INTO actes_matieres ( code_matiere, libelle_matiere ) VALUES ( ?, ? ) ";
    private static final String SQL_QUERY_DELETE = "DELETE FROM actes_matieres WHERE code_matiere = ? ";
    private static final String SQL_QUERY_UPDATE = "UPDATE actes_matieres SET code_matiere = ?, libelle_matiere = ? WHERE code_matiere = ?";
    private static final String SQL_QUERY_SELECTALL = "SELECT code_matiere, libelle_matiere FROM actes_matieres";

    /**
     * Insert a new record in the table.
     * @param matiere instance of the Matiere object to insert
     * @param plugin The plugin
     */
    public void insert( Matiere matiere, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, plugin );

        daoUtil.setString( 1, matiere.getCodeMatiere(  ) );
        daoUtil.setString( 2, matiere.getLibelleMatiere(  ) );

        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the data of the matiere from the table
     * @param strIdMatiere The identifier of the matiere
     * @param plugin The plugin
     * @return the instance of the Matiere
     */
    public Matiere load( String strIdMatiere, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin );
        daoUtil.setString( 1, strIdMatiere );
        daoUtil.executeQuery(  );

        Matiere matiere = null;

        if ( daoUtil.next(  ) )
        {
            matiere = new Matiere(  );

            matiere.setCodeMatiere( daoUtil.getString( 1 ) );
            matiere.setLibelleMatiere( daoUtil.getString( 2 ) );
        }

        daoUtil.free(  );

        return matiere;
    }

    /**
     * Delete a record from the table
     * @param strIdMatiere The identifier of the matiere
     * @param plugin The plugin
     */
    public void delete( String strIdMatiere, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin );
        daoUtil.setString( 1, strIdMatiere );
        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Update the record in the table
     * @param matiere The reference of the matiere
     * @param plugin The plugin
     */
    public void store( Matiere matiere, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE, plugin );

        daoUtil.setString( 1, matiere.getCodeMatiere(  ) );
        daoUtil.setString( 2, matiere.getLibelleMatiere(  ) );
        daoUtil.setString( 3, matiere.getCodeMatiere(  ) );

        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the data of all the matieres and returns them as a collection
     * @param plugin The plugin
     * @return The Collection which contains the data of all the matieres
     */
    public Collection<Matiere> selectMatieresList( Plugin plugin )
    {
        Collection<Matiere> listMatieres = new ArrayList<Matiere>(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            Matiere matiere = new Matiere(  );

            matiere.setCodeMatiere( daoUtil.getString( 1 ) );
            matiere.setLibelleMatiere( daoUtil.getString( 2 ) );

            listMatieres.add( matiere );
        }

        daoUtil.free(  );

        return listMatieres;
    }

    /**
     * Load the data of all the matieres and returns them as a ReferenceList
     * @param plugin The plugin
     * @return The ReferenceList which contains the data of all the matieres
     */
    public ReferenceList getMatieresList( Plugin plugin )
    {
        ReferenceList listMatieres = new ReferenceList(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            Matiere matiere = new Matiere(  );

            matiere.setCodeMatiere( daoUtil.getString( 1 ) );
            matiere.setLibelleMatiere( daoUtil.getString( 2 ) );

            listMatieres.addItem( matiere.getCodeMatiere(  ),
                matiere.getCodeMatiere(  ) + " - " + matiere.getLibelleMatiere(  ) );
        }

        daoUtil.free(  );

        return listMatieres;
    }
}
