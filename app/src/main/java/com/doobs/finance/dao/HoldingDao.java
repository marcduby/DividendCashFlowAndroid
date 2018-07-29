package com.doobs.finance.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.doobs.finance.model.Holding;

import java.util.List;

/**
 * Data access interface to manage the stock holdings
 *
 * Created by mduby on 7/29/18.
 */
@Dao
public interface HoldingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(Holding holding);

    @Delete
    public void delete(Holding holding);

    @Update
    public void update(Holding holding);

    @Query("delete from inv_investment_holding")
    public void deleteAll();

    @Query("select * from inv_investment_holding order by symbol")
    public List<Holding> getAllHoldings();

}
