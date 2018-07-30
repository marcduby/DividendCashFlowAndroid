package com.doobs.finance.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.doobs.finance.repository.HoldingRepository;

import java.util.List;

/**
 * Created by mduby on 7/29/18.
 */

public class HoldingViewModel extends AndroidViewModel {
    // instance variables
    private HoldingRepository holdingRepository;
    private LiveData<List<Holding>> holdings;

    /**
     * default constructor
     *
     * @param application
     */
    public HoldingViewModel(Application application) {
        super(application);
        this.holdingRepository = new HoldingRepository(application);
        this.holdings = this.holdingRepository.getHoldings();
    }

    public LiveData<List<Holding>> getHoldings() {
        return holdings;
    }

    /**
     * insert holding data into db
     *
     * @param holding
     */
    public void insert(Holding holding) {
        this.holdingRepository.insert(holding);
    }
}
