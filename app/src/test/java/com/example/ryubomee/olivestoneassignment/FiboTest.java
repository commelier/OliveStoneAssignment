package com.example.ryubomee.olivestoneassignment;

import com.example.ryubomee.olivestoneassignment.data.HistoryData;

import org.junit.Test;

/**
 * Created by RyuBomee on 2017. 12. 11..
 */

public class FiboTest {

    @Test
    public void testFibo(){
        HistoryData historyData = new HistoryData();
        long result = historyData.getCalcFibo(10);
        long expected = 55;
        assert(result == expected);
    }
}
