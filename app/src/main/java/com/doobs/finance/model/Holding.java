package com.doobs.finance.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Class to hold stock holding data
 *
 * Created by mduby on 7/29/18.
 */
@Entity(tableName="inv_investment_holding")
public class Holding {
    // instance variables
    @NonNull
    @ColumnInfo(name = "symbol")
    private String symbol;

    @NonNull
    @ColumnInfo(name = "price_bought")
    private Double priceBought;

    @NonNull
    @ColumnInfo(name = "yearly_dividend")
    private Double yearlyDividend;

    @NonNull
    @ColumnInfo(name = "number_of_shares")
    private Double numberOfShares;

    // auto generated
    @PrimaryKey(autoGenerate = true)
    private int holdingId;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPriceBought() {
        return priceBought;
    }

    public void setPriceBought(Double priceBought) {
        this.priceBought = priceBought;
    }

    public Double getYearlyDividend() {
        return yearlyDividend;
    }

    public void setYearlyDividend(Double yearlyDividend) {
        this.yearlyDividend = yearlyDividend;
    }

    public Double getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Double numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public int getHoldingId() {
        return holdingId;
    }

    public void setHoldingId(int holdingId) {
        this.holdingId = holdingId;
    }
}
