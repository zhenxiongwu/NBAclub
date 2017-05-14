package com.example.asus1.nbatest.util;


import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.YAxis;

import java.util.List;

/**
 * Created by yubin on 2017/5/11.
 */

public class HorizontalBarChartStyleSetter extends ChartStyleSetter {

    public static void setHorizontalBarChartStyle(HorizontalBarChart chart, List<String> xValuesList) {
        setChartStyle(chart, xValuesList);

        //y轴
        YAxis yl = chart.getAxisLeft();
        yl.setTextColor(0xffffffff);
        yl.setDrawAxisLine(true);
        yl.setDrawGridLines(true);
        yl.setTextSize(15f);
        yl.setAxisMinimum(0f);

        //y轴
        YAxis yr = chart.getAxisRight();
        yr.setTextColor(0xffffffff);
        yr.setDrawAxisLine(true);
        yr.setDrawGridLines(false);
        yr.setTextSize(15f);
        yr.setAxisMinimum(0f);

        chart.setFitBars(true);

    }

}
