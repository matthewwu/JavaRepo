package com.mwu.finance.accessMongo;

import com.mwu.finance.model.Portfolio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by mwu on 6/8/15.
 */
public class PortfolioRepositoryMongo implements IPortfolioRepositoryMongo {


    @Override
    public Portfolio save(Portfolio p) {
        return null;
    }

    @Override
    public Portfolio findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public <S extends Portfolio> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public List<Portfolio> findAll() {
        return null;
    }

    @Override
    public Iterable<Portfolio> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Portfolio portfolio) {

    }

    @Override
    public void delete(Iterable<? extends Portfolio> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Portfolio> findAll(Sort sort) {
        return null;
    }

    @Override
    public <S extends Portfolio> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Page<Portfolio> findAll(Pageable pageable) {
        return null;
    }



    @Override
    public Portfolio insert(Portfolio p) {
        return null;
    }
}
