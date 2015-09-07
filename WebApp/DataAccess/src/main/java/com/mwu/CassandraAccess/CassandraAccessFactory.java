package com.mwu.CassandraAccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.cassandra.core.CassandraOperations;

/**
 * Created by mwu on 7/13/15.
 */
public class CassandraAccessFactory {

    public static CassandraOperations getCassandraAccess(){
        ApplicationContext ctx = new GenericXmlApplicationContext("ApplicationContext.xml");
        CassandraOperations cassandraOperations = ctx.getBean("cassandraTemplate", CassandraOperations.class);

        return cassandraOperations;
    }
}
