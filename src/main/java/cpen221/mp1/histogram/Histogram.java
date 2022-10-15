package cpen221.mp1.histogram;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

import java.util.*;

public class Histogram {

    private final int chartWidth  = 800;
    private final int chartHeight = 600;
    private final double fillFraction = 0.8;

    private CategoryChart chart;

    /**
     * constructor of histogram with given chart name, x, y Axis title.
     * @param chartTitle the name of the chart
     * @param xAxisTitle title of x-axis
     * @param yAxisTitle title of y-axis
     */
    public Histogram(String chartTitle, String xAxisTitle, String yAxisTitle) {
        chart = new CategoryChartBuilder().width(chartWidth).height(chartHeight)
                .title(chartTitle)
                .xAxisTitle(xAxisTitle)
                .yAxisTitle(yAxisTitle)
                .build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setAvailableSpaceFill(fillFraction);
        chart.getStyler().setOverlapped(false);
    }

    /**
     * construct a histogram with given seriesName, x Date and y Data
     * @param seriesName name of one series we construct
     * @param xData categorizations shown on x-axis.
     * @param yData count of each xData shown on y-axis.
     */
    public void addSeries(String seriesName, List xData, List yData) {
        chart.addSeries(seriesName, xData, yData);
    }

    /**
     * display the histogram chart
     */

    public void showChart() {
        new SwingWrapper<>(chart).displayChart();
    }

}
