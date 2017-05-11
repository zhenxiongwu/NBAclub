package com.example.asus1.nbatest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.asus1.nbatest.database.table.model.Player;
import com.example.asus1.nbatest.database.util.Selector;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.asus1.nbatest", appContext.getPackageName());


        /**
         * my test
         */
        assertEquals(Selector.selectPlayerByName("Quincy Acy").size(),2);
        assertEquals(Selector.selectTeamChampionships("San Antonio Spurs"),4);
        assertEquals(Selector.selectArenaTeam("OracleArena"),"Golden State Warriors");

        List<Player> players = Selector.fuzzySelectPlayers("james");
        assertTrue( players.size() > 0);
        Log.i("zhenxiongwu","palyers size: "+players.size());
        for(Player player : players)
            Log.i("zhenxiongwu","player name is "+player.getName());
    }
}
