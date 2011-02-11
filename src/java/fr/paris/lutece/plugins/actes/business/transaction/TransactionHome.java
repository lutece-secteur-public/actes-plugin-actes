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
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;

import java.util.Collection;


/**
 * This class provides instances management methods (create, find, ...) for Transaction objects
 */
public final class TransactionHome
{
    private static final String PLUGIN_NAME = "actes";

    // Static variable pointed at the DAO instance
    private static ITransactionDAO _dao = (ITransactionDAO) SpringContextService.getPluginBean( "actes",
            "actes.transactionDAO" );
    private static Plugin _plugin = PluginService.getPlugin( PLUGIN_NAME );

    /**
     * Private constructor - this class need not be instantiated
     */
    private TransactionHome(  )
    {
    }

    /**
     * Create an instance of the transaction class
     * @param transaction The instance of the Transaction which contains the informations to store
     * @return The  instance of transaction which has been created with its primary key.
     */
    public static Transaction create( Transaction transaction )
    {
        _dao.insert( transaction, _plugin );

        return transaction;
    }

    /**
     * Update of the transaction which is specified in parameter
     * @param transaction The instance of the Transaction which contains the data to store
     * @param plugin the plugin
     * @return The instance of the  transaction which has been updated
     */
    public static Transaction update( Transaction transaction, Plugin plugin )
    {
        _dao.store( transaction, _plugin );

        return transaction;
    }

    /**
     * Remove the transaction whose identifier is specified in parameter
     * @param nTransactionId The transaction Id
     */
    public static void remove( int nTransactionId )
    {
        _dao.delete( nTransactionId, _plugin );
    }

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Returns an instance of a transaction whose identifier is specified in parameter
     * @param nKey The transaction primary key
     * @return an instance of Transaction
     */
    public static Transaction findByPrimaryKey( int nKey )
    {
        return _dao.load( nKey, _plugin );
    }

    /**
     * Load the data of all the transaction objects and returns them in form of a collection
     * @return the collection which contains the data of all the transaction objects
     */
    public static Collection<Transaction> getTransactionsList(  )
    {
        return _dao.selectTransactionsList( _plugin );
    }
}
