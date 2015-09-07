package com.mwu.CassandraAccess;

import com.mwu.DataModel.LinkFrom;

import java.util.List;

/**
 * Created by mwu on 7/13/15.
 */
public interface DataAccess {

    void SaveLinkFroms(List<LinkFrom> linkFroms);
}
