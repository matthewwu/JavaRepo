package com.mwu.finance.access;

import com.mwu.finance.model.Portfolio;

import java.util.List;

/**
 * Created by mwu on 6/7/15.
 */
public interface IFinanceAccess {
    void StorePorfolioBatch(List<Portfolio> PortfolioCol);
    List<Portfolio> LoadPorfolioByKeys(Long[] keys);
}
