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

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.sql.DAOUtil;

import java.util.ArrayList;
import java.util.Collection;


/**
 * This class provides Data Access methods for Transaction objects
 */
public final class TransactionDAO implements ITransactionDAO
{
    // Constants
    private static final String SQL_QUERY_NEW_PK = "SELECT max( id_transaction ) FROM actes_transaction";
    private static final String SQL_QUERY_SELECT = "SELECT id_transaction, code_transaction, nature, classification, date_decision, numero_interne, objet, status FROM actes_transaction WHERE id_transaction = ?";
    private static final String SQL_QUERY_INSERT = "INSERT INTO actes_transaction ( id_transaction, code_transaction, nature, classification, date_decision, numero_interne, objet, status ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? ) ";
    private static final String SQL_QUERY_DELETE = "DELETE FROM actes_transaction WHERE id_transaction = ? ";
    private static final String SQL_QUERY_UPDATE = "UPDATE actes_transaction SET id_transaction = ?, code_transaction = ?, nature = ?, classification = ?, date_decision = ?, numero_interne = ?, objet = ?, status = ? WHERE id_transaction = ?";
    private static final String SQL_QUERY_SELECTALL = "SELECT id_transaction, code_transaction, nature, classification, date_decision, numero_interne, objet, status FROM actes_transaction ORDER BY id_transaction DESC";

    /**
     * Generates a new primary key
     * @param plugin The Plugin
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
     * @param transaction instance of the Transaction object to insert
     * @param plugin The plugin
     */
    public void insert( Transaction transaction, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, plugin );

        transaction.setId( newPrimaryKey( plugin ) );

        daoUtil.setInt( 1, transaction.getId(  ) );
        daoUtil.setString( 2, transaction.getCode(  ) );
        daoUtil.setString( 3, transaction.getNature(  ) );
        daoUtil.setString( 4, transaction.getClassification(  ) );
        daoUtil.setString( 5, transaction.getDateDecision(  ) );
        daoUtil.setString( 6, transaction.getNumeroInterne(  ) );
        daoUtil.setString( 7, transaction.getObjet(  ) );
        daoUtil.setInt( 8, transaction.getStatus(  ) );

        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the data of the transaction from the table
     * @param nId The identifier of the transaction
     * @param plugin The plugin
     * @return the instance of the Transaction
     */
    public Transaction load( int nId, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin );
        daoUtil.setInt( 1, nId );
        daoUtil.executeQuery(  );

        Transaction transaction = null;

        if ( daoUtil.next(  ) )
        {
            transaction = new Transaction(  );

            transaction.setId( daoUtil.getInt( 1 ) );
            transaction.setCode( daoUtil.getString( 2 ) );
            transaction.setNature( daoUtil.getString( 3 ) );
            transaction.setClassification( daoUtil.getString( 4 ) );
            transaction.setDateDecision( daoUtil.getString( 5 ) );
            transaction.setNumeroInterne( daoUtil.getString( 6 ) );
            transaction.setObjet( daoUtil.getString( 7 ) );
            transaction.setStatus( daoUtil.getInt( 8 ) );
        }

        daoUtil.free(  );

        return transaction;
    }

    /**
     * Delete a record from the table
     * @param nTransactionId The identifier of the transaction
     * @param plugin The plugin
     */
    public void delete( int nTransactionId, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin );
        daoUtil.setInt( 1, nTransactionId );
        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Update the record in the table
     * @param transaction The reference of the transaction
     * @param plugin The plugin
     */
    public void store( Transaction transaction, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE, plugin );

        daoUtil.setInt( 1, transaction.getId(  ) );
        daoUtil.setString( 2, transaction.getCode(  ) );
        daoUtil.setString( 3, transaction.getNature(  ) );
        daoUtil.setString( 4, transaction.getClassification(  ) );
        daoUtil.setString( 5, transaction.getDateDecision(  ) );
        daoUtil.setString( 6, transaction.getNumeroInterne(  ) );
        daoUtil.setString( 7, transaction.getObjet(  ) );
        daoUtil.setInt( 8, transaction.getStatus(  ) );
        daoUtil.setInt( 9, transaction.getId(  ) );

        daoUtil.executeUpdate(  );
        daoUtil.free(  );
    }

    /**
     * Load the data of all the transactions and returns them as a collection
     * @param plugin The plugin
     * @return The Collection which contains the data of all the transactions
     */
    public Collection<Transaction> selectTransactionsList( Plugin plugin )
    {
        Collection<Transaction> transactionList = new ArrayList<Transaction>(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            Transaction transaction = new Transaction(  );

            transaction.setId( daoUtil.getInt( 1 ) );
            transaction.setCode( daoUtil.getString( 2 ) );
            transaction.setNature( daoUtil.getString( 3 ) );
            transaction.setClassification( daoUtil.getString( 4 ) );
            transaction.setDateDecision( daoUtil.getString( 5 ) );
            transaction.setNumeroInterne( daoUtil.getString( 6 ) );
            transaction.setObjet( daoUtil.getString( 7 ) );
            transaction.setStatus( daoUtil.getInt( 8 ) );

            transactionList.add( transaction );
        }

        daoUtil.free(  );

        return transactionList;
    }
}
