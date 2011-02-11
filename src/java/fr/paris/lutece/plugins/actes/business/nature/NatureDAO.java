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
import fr.paris.lutece.util.sql.DAOUtil;

import java.util.ArrayList;
import java.util.Collection;


/**
 * This class provides Data Access methods for Nature objects
 */
public final class NatureDAO implements INatureDAO
{
    // Constants
    private static final String SQL_QUERY_NEW_PK = "SELECT max( id_nature ) FROM actes_nature";
    private static final String SQL_QUERY_SELECT = "SELECT id_nature, code, name FROM actes_nature WHERE id_nature = ?";
    private static final String SQL_QUERY_INSERT = "INSERT INTO actes_nature ( id_nature, code, name ) VALUES ( ?, ?, ? ) ";
    private static final String SQL_QUERY_DELETE = "DELETE FROM actes_nature WHERE id_nature = ? ";
    private static final String SQL_QUERY_UPDATE = "UPDATE actes_nature SET id_nature = ?, code = ?, name = ? WHERE id_nature = ?";
    private static final String SQL_QUERY_SELECTALL = "SELECT id_nature, code, name FROM actes_nature";

    /**
     * Generates a new primary key
     * @param plugin The plugin
     * @return The new primary key
     */
    public int newPrimaryKey( Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_NEW_PK, plugin );
        daoUtil.executeQuery(  );

        int nKey;

        if ( !daoUtil.next(  ) )
        {
            // if the table is empty
            nKey = 1;
        }

        nKey = daoUtil.getInt( 1 ) + 1;
        daoUtil.free(  );

        return nKey;
    }

    /**
     * Insert a new record in the table.
     * @param nature instance of the Nature object to insert
     * @param plugin The plugin
     */
    public void insert( Nature nature, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, plugin );

        nature.setId( newPrimaryKey( plugin ) );

        daoUtil.setInt( 1, nature.getId(  ) );
        daoUtil.setString( 2, nature.getCode(  ) );
        daoUtil.setString( 3, nature.getName(  ) );

        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the data of the nature from the table
     * @param nId The identifier of the nature
     * @param plugin The plugin
     * @return the instance of the Nature
     */
    public Nature load( int nId, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin );
        daoUtil.setInt( 1, nId );
        daoUtil.executeQuery(  );

        Nature nature = null;

        if ( daoUtil.next(  ) )
        {
            nature = new Nature(  );

            nature.setId( daoUtil.getInt( 1 ) );
            nature.setCode( daoUtil.getString( 2 ) );
            nature.setName( daoUtil.getString( 3 ) );
        }

        daoUtil.free(  );

        return nature;
    }

    /**
     * Delete a record from the table
     * @param nNatureId The identifier of the nature
     * @param plugin The plugin
     */
    public void delete( int nNatureId, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin );
        daoUtil.setInt( 1, nNatureId );
        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Update the record in the table
     * @param nature The reference of the nature
     * @param plugin The plugin
     */
    public void store( Nature nature, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE, plugin );

        daoUtil.setInt( 1, nature.getId(  ) );
        daoUtil.setString( 2, nature.getCode(  ) );
        daoUtil.setString( 3, nature.getName(  ) );
        daoUtil.setInt( 4, nature.getId(  ) );

        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the data of all the natures and returns them as a collection
     * @param plugin The plugin
     * @return The Collection which contains the data of all the natures
     */
    public Collection<Nature> selectNaturesList( Plugin plugin )
    {
        Collection<Nature> natureList = new ArrayList<Nature>(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            Nature nature = new Nature(  );

            nature.setId( daoUtil.getInt( 1 ) );
            nature.setCode( daoUtil.getString( 2 ) );
            nature.setName( daoUtil.getString( 3 ) );

            natureList.add( nature );
        }

        daoUtil.free(  );

        return natureList;
    }

    /**
     * Load the data of all the natures and returns them as a reference list
     * @param plugin The plugin
     * @return The reference list which contains the data of all the natures
     */
    public ReferenceList getNaturesList( Plugin plugin )
    {
        ReferenceList natureList = new ReferenceList(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            Nature nature = new Nature(  );

            nature.setId( daoUtil.getInt( 1 ) );
            nature.setCode( daoUtil.getString( 2 ) );
            nature.setName( daoUtil.getString( 3 ) );

            natureList.addItem( nature.getId(  ), nature.getName(  ) );
        }

        daoUtil.free(  );

        return natureList;
    }
}
