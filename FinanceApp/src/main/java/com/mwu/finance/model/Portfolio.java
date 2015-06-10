package com.mwu.finance.model;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwu on 6/7/15.
 */
public class Portfolio {


    @Id
    private long id;

    private long pid;

    private List<Asset> assets;

    public Portfolio()
    {
        assets = new ArrayList<Asset>();
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
