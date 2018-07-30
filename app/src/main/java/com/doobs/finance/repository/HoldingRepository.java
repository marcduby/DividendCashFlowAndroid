package com.doobs.finance.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.doobs.finance.dao.HoldingDao;
import com.doobs.finance.database.HoldingRoomDatabase;
import com.doobs.finance.model.Holding;

import java.util.List;

/**
 * Repository class to communicate with the dao
 *
 * Created by mduby on 7/29/18.
 */

public class HoldingRepository {
    // instance variables
    private HoldingDao holdingDao;
    private LiveData<List<Holding>> holdings;

    /**
     * default constructor
     *
     * @param application
     */
    public HoldingRepository(Application application) {
        HoldingRoomDatabase holdingRoomDatabase = HoldingRoomDatabase.getInstance(application);
        this.holdingDao = holdingRoomDatabase.holdingDao();
        this.holdings = this.holdingDao.getAllHoldings();
    }

    public LiveData<List<Holding>> getHoldings() {
        return holdings;
    }

    /**
     * insert holding data
     *
     * @param holding
     */
    public void insert(Holding holding) {
        new InsertAsyncTask(this.holdingDao).execute(holding);
    }

    /**
     * task for the db inserts
     */
    public static class InsertAsyncTask extends AsyncTask<Holding, Void, Void> {
        // instance variables
        private HoldingDao holdingDao;

        /**
         * default constructor
         *
         */
        public InsertAsyncTask(HoldingDao dao) {
            this.holdingDao = dao;
        }

        @Override
        protected Void doInBackground(Holding... holdings) {
            this.holdingDao.insert(holdings[0]);
            return null;
        }
    }
}
