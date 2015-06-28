package com.mwu.finance.accessMongo;

import com.mwu.finance.access.IFinanceAccess;
import com.mwu.finance.model.Portfolio;

import java.util.List;

/**
 * Created by mwu on 6/16/15.
 */
public class FinanceMongoAccess implements IFinanceAccess {
    @Override
    public void StorePorfolioBatch(List<Portfolio> PortfolioCol) {

    }

    @Override
    public List<Portfolio> LoadPorfolioByKeys(Long[] keys) {
        return null;
    }
}
