package com.mwu.DataModel;

import com.datastax.driver.core.querybuilder.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.io.Serializable;

/**
 * Created by mwu on 7/13/15.
 */
@PrimaryKeyClass
public class LinkFromKey implements Serializable {

    @PrimaryKeyColumn(name = "from_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private long from_id;

    @PrimaryKeyColumn(name = "score", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = org.springframework.cassandra.core.Ordering.DESCENDING)
    private float score;

    public long getFrom_id() {
        return from_id;
    }

    public void setFrom_id(long from_id) {
        this.from_id = from_id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
