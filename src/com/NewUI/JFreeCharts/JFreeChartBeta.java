package com.NewUI.JFreeCharts;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFreeChartBeta {

	public CategoryDataset createBarDataset() {

		// row keys
		String series1 = "First";
		String series2 = "Second";
		String series3 = "Third";
		// column keys
		String category1 = "Category 1";
		String category2 = "Category 2";
		String category3 = "Category 3";
		String category4 = "Category 4";
		String category5 = "Category 5";

		// create the dataset
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(1.0, series1, category1);
		dataset.addValue(4.0, series1, category2);
		dataset.addValue(3.0, series1, category3);
		dataset.addValue(5.0, series1, category4);
		dataset.addValue(5.0, series1, category5);
		dataset.addValue(5.0, series2, category1);
		dataset.addValue(7.0, series2, category2);
		dataset.addValue(6.0, series2, category3);
		dataset.addValue(8.0, series2, category4);
		dataset.addValue(4.0, series2, category5);
		dataset.addValue(4.0, series3, category1);
		dataset.addValue(3.0, series3, category2);
		dataset.addValue(2.0, series3, category3);
		dataset.addValue(3.0, series3, category4);
		dataset.addValue(6.0, series3, category5);
		return dataset;
	}

	/**
	 * Creates a sample chart.
	 * 
	 * @param dataset
	 *            the dataset.
	 * 
	 * @return The chart.
	 */
	public JFreeChart createBarChart(CategoryDataset bardataset) {
		// create the chart
		JFreeChart chart = ChartFactory.createBarChart("Volume Chart Demo", // chart
				// title
				"Category", // domain axis label
				"Value", // range axis label
				bardataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips
				false // URLs
				);

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART

		// set the background color for the chart
		chart.setBackgroundPaint(Color.white);

		// get a reference to the plot for further customisation
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setDomainGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.white);

		// set the range axis to display integers only
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		// disable bar outlines
		// BarRenderer renderer = (BarRenderer) plot.getRenderer();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions
				.createUpRotationLabelPositions(Math.PI / 6.0));
		// OPTIONAL CUSTOMISATION COMPLETED.

		return chart;

	}

	public static DefaultCategoryDataset createLineDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// 各曲线名称
		String series1 = "line1";
		String series2 = "line2";
		String series3 = "line3";

		// 横轴名称(列名称)
		String type1 = "1";
		String type2 = "2";
		String type3 = "3";

		dataset.addValue(0.0, series1, type1);
		dataset.addValue(4.2, series1, type2);
		dataset.addValue(3.9, series1, type3);

		dataset.addValue(1.0, series2, type1);
		dataset.addValue(5.2, series2, type2);
		dataset.addValue(7.9, series2, type3);

		dataset.addValue(2.0, series3, type1);
		dataset.addValue(9.2, series3, type2);
		dataset.addValue(8.9, series3, type3);

		return dataset;
	}

	public JFreeChart createLineChart(DefaultCategoryDataset linedataset) {
		// 定义图表对象
		JFreeChart chart = ChartFactory.createLineChart("Z-Score", // chart title
				"function", // domain axis label
				"Zscore", // range axis label
				linedataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips
				false // urls
				);
		CategoryPlot plot = chart.getCategoryPlot();
		// customise the range axis...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		rangeAxis.setUpperMargin(0.20);
		rangeAxis.setLabelAngle(0);

		return chart;
	}

}
