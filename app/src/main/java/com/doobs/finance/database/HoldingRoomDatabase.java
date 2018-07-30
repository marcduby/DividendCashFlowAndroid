package com.doobs.finance.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.doobs.finance.dao.HoldingDao;
import com.doobs.finance.model.Holding;

/**
 * Room database class for the holding object management
 *
 * Created by mduby on 7/29/18.
 */
@Database(entities = {Holding.class}, version = 1)
public abstract class HoldingRoomDatabase extends RoomDatabase {
    // static variables
    private static HoldingRoomDatabase holdingRoomDatabase;

    /**
     * singleton method
     *
     * @param context
     * @return
     */
    public static HoldingRoomDatabase getInstane(final Context context) {
        if (holdingRoomDatabase == null) {
            synchronized (HoldingRoomDatabase.class) {
                holdingRoomDatabase = Room.databaseBuilder(context.getApplicationContext(), HoldingRoomDatabase.class, "holding_database").build();
            }
        }

        // return
        return holdingRoomDatabase;
    }

    /**
     * handles the dao
     *
     * @return
     */
    public abstract HoldingDao holdingDao();
}
