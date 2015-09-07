package com.mwu.DataModel;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mwu on 7/13/15.
 */
@Table(value = "LinkResult_From")
public class LinkFrom implements Serializable{

    @PrimaryKey
    private LinkFromKey pk;

    @Column(value = "from_db")
    private String fromDb;

    @Column(value = "from_source_id")
    private int fromSourceId;

    @Column(value = "to_id")
    private long toId;

    @Column(value = "cDate")
    private Date cDate;


    @Column(value = "to_db")
    private String toDb;

    @Column(value = "uDate")
    private Date uDate;

    public LinkFromKey getPk() {
        return pk;
    }

    public void setPk(LinkFromKey pk) {
        this.pk = pk;
    }

    public String getFromDb() {
        return fromDb;
    }

    public void setFromDb(String fromDb) {
        this.fromDb = fromDb;
    }

    public int getFromSourceId() {
        return fromSourceId;
    }

    public void setFromSourceId(int fromSourceId) {
        this.fromSourceId = fromSourceId;
    }

    public long getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public String getToDb() {
        return toDb;
    }

    public void setToDb(String toDb) {
        this.toDb = toDb;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getuDate() {
        return uDate;
    }

    public void setuDate(Date uDate) {
        this.uDate = uDate;
    }
}
