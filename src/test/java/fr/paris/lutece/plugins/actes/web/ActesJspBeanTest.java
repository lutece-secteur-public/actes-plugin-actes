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
package fr.paris.lutece.plugins.actes.web;

import fr.paris.lutece.test.LuteceTestCase;
import fr.paris.lutece.test.MokeHttpServletRequest;


/**
 * ActesJspBean test
 */
public class ActesJspBeanTest extends LuteceTestCase
{
    public ActesJspBeanTest( String testName )
    {
        super( testName );
    }

    /**
     * Test of manageActes method, of class fr.paris.lutece.plugins.actes.web.ActesJspBean.
     */
    public void testManageActes(  )
    {
        System.out.println( "manageActes" );

        MokeHttpServletRequest request = new MokeHttpServletRequest(  );
        ActesJspBean instance = new ActesJspBean(  );

        String expResult = "";
        String result = instance.manageActes( request );
    }

    /**
     * Test of getCreateActe method, of class fr.paris.lutece.plugins.actes.web.ActesJspBean.
     */
    public void testGetCreateActe(  )
    {
        System.out.println( "getCreateActe" );

        MokeHttpServletRequest request = new MokeHttpServletRequest(  );
        ActesJspBean instance = new ActesJspBean(  );

        String expResult = "";
        String result = instance.getCreateActe( request );
    }

    /**
     * Test of doCreateActe method, of class fr.paris.lutece.plugins.actes.web.ActesJspBean.
     */
    public void testDoCreateActe(  )
    {
        System.out.println( "doCreateActe" );

        MokeHttpServletRequest request = new MokeHttpServletRequest(  );
        request.addMokeParameters( "nature", "1" );
        request.addMokeParameters( "classification", "1.1" );
        request.addMokeParameters( "numero", "15456456454" );
        request.addMokeParameters( "date_decision", "11/11/2008" );
        request.addMokeParameters( "objet", "test" );

        ActesJspBean instance = new ActesJspBean(  );

        String expResult = "";
        String result = instance.doCreateActe( request );
    }
}
