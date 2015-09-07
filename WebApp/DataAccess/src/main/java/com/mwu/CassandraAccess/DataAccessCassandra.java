package com.mwu.CassandraAccess;

import com.mwu.DataModel.LinkFrom;
import org.springframework.data.cassandra.core.CassandraOperations;

import java.util.List;

/**
 * Created by mwu on 7/13/15.
 */
public class DataAccessCassandra implements DataAccess{

    private final CassandraOperations cassandraOperations;

    public DataAccessCassandra(CassandraOperations cassandraOperations){
        this.cassandraOperations = cassandraOperations;
    }

    public void SaveLinkFroms(List<LinkFrom> linkFroms){

        cassandraOperations.insert(linkFroms);
    }
}
