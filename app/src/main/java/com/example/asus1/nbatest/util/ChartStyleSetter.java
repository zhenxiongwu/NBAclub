package com.example.asus1.nbatest.util;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yubin on 2017/5/9.
 */

public class ChartStyleSetter {

    /**
     *
     * @param chart 图表类
     * @param xValuesList 球队名称或赛季
     */
    public static void setChartStyle(Chart chart, List<String> xValuesList) {

        //设置相关属性
        chart.getDescription().setEnabled(false);
        chart.setBackgroundColor(0xff000000);

        List<String> xVals = new ArrayList<>();

        for (int i = 0; i < xValuesList.size(); i++) {
            xVals.add(xValuesList.get(i));
        }

        //x轴
        XAxis xl = chart.getXAxis();
        MyXFormatter formatter = new MyXFormatter(xVals.toArray(new String[0]));
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setDrawAxisLine(true);
        xl.setTextColor(0xffffffff);
        xl.setDrawGridLines(false);
        //显示个数
        xl.setLabelCount(xValuesList.size());
        if (chart instanceof HorizontalBarChart) {
            xl.setLabelRotationAngle(0);
        }else {
            xl.setLabelRotationAngle(90);

        }
        xl.setTextSize(15f);
        xl.setValueFormatter(formatter);
        xl.setGranularity(1f);

        Legend l = chart.getLegend();
        l.setTextColor(0xffffffff);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setTextSize(15f);
        l.setFormSize(8f);
        l.setXEntrySpace(4f);
    }

}