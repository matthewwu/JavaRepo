package com.mwu.webApp;

import com.mwu.CassandraAccess.CassandraAccessFactory;
import com.mwu.CassandraAccess.DataAccess;
import com.mwu.CassandraAccess.DataAccessCassandra;
import com.mwu.DataModel.LinkFrom;
import com.mwu.DataModel.LinkFromKey;
import com.mwu.webApp.Greeting;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.cassandra.core.PrimaryKeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mwu on 6/29/15.
 */
@RestController
@RequestMapping("/Linkfrom")
public class LinkFromController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/{from_id}", method= RequestMethod.GET)
    public List<LinkFrom> getLinkFrom(@PathVariable long from_id) {
        List<LinkFrom> lfs = new ArrayList<>();

        LinkFrom lf = new LinkFrom();
        LinkFromKey lfk = new LinkFromKey();
        lfk.setFrom_id(from_id);
        lfk.setScore(75);
        lf.setPk(lfk);

        LinkFrom lf2 = new LinkFrom();
        LinkFromKey lfk2 = new LinkFromKey();
        lfk2.setFrom_id(from_id);
        lfk2.setScore(85);
        lf.setPk(lfk);

        lfs.add(lf);
        lfs.add(lf2);
        return lfs;
    }

    @RequestMapping(method= RequestMethod.POST)
    public LinkFrom saveLinkFrom(LinkFrom linkFrom) {

        CassandraOperations cassandraOperation = CassandraAccessFactory.getCassandraAccess();
        DataAccess access = new DataAccessCassandra(cassandraOperation);

        List<LinkFrom> lf = new ArrayList<>();
        lf.add(linkFrom);
        access.SaveLinkFroms(lf);

        return new LinkFrom();
    }

}
