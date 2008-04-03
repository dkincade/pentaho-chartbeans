/**
 * 
 */
package org.pentaho.experimental.chart.plugin.jfreechart.utils;


import java.awt.Color;
import java.awt.GradientPaint;
import java.util.List;

import junit.framework.TestCase;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.resourceloader.ResourceException;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.junit.After;
import org.junit.Before;
import org.pentaho.experimental.chart.ChartDocumentContext;
import org.pentaho.experimental.chart.ChartFactory;
import org.pentaho.experimental.chart.core.ChartDocument;
import org.pentaho.experimental.chart.core.ChartElement;

/**
 * @author Ravi Hasija
 *
 */
public class JFreeChartUtilsTest extends TestCase {

  String[] testFileNames = {
      "JFreeChartUtilsTest1.xml", //$NON-NLS-1$
      "JFreeChartUtilsTest2.xml", //$NON-NLS-1$
      "JFreeChartUtilsTest3.xml", //$NON-NLS-1$
      "JFreeChartUtilsTest4.xml", //$NON-NLS-1$
  };

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }
  
  public void testGetOrientation() throws ResourceException {
    PlotOrientation[] expectedValues = {
         PlotOrientation.VERTICAL,
         PlotOrientation.HORIZONTAL,
         PlotOrientation.VERTICAL,
         PlotOrientation.HORIZONTAL,
    };

    for (int i = 0; i < testFileNames.length; i++) {
      ChartDocumentContext cdc = ChartFactory.generateChart(getClass().getResource(testFileNames[i])); 
      assertNotNull(cdc);
      ChartDocument cd = cdc.getChartDocument();
      assertNotNull(cd);    

      ChartElement plotElement = cd.getPlotElement();
      if (i == 0) {
        assertEquals(null, plotElement);
      } else {  
        assertEquals(expectedValues[i], JFreeChartUtils.getPlotOrientation(cd));
      }
    }
  }

  public void testShowURLs() throws ResourceException {

    boolean[] expectedValues = {
         false,
         true,
         false,
         false,
    };

    for (int i = 0; i < testFileNames.length; i++) {
      ChartDocumentContext cdc = ChartFactory.generateChart(getClass().getResource(testFileNames[i])); 
      assertNotNull(cdc);
      ChartDocument cd = cdc.getChartDocument();
      assertNotNull(cd);    

      ChartElement plotElement = cd.getPlotElement();
      if (i == 0) {
        assertEquals(null, plotElement);
      } else {  
        assertEquals("Counter# " + i, expectedValues[i], JFreeChartUtils.getShowUrls(cd)); //$NON-NLS-1$
      }
    }
  }

  /*
   * 
   */
  public void testGradientPaint() throws ResourceException {
    
    GradientPaint[] expectedValues = new GradientPaint[] {
      null,
      new GradientPaint(0,0, Color.black, 1,1, Color.white),
      new GradientPaint(0.5f,99.90f, Color.black, 1,1, Color.white),  
      new GradientPaint(1f,2f, Color.black, 1,1, Color.white),  
      new GradientPaint(0,0, Color.black, 1.5f,8.5f, Color.white),  
      new GradientPaint(0,0, Color.black, 3,4, Color.white),  
      new GradientPaint(1,2, Color.gray, 3,4, Color.cyan),  
      new GradientPaint(1,10, Color.red, 2,20, Color.white),  
      new GradientPaint(0,0, new Color(0,255,0), 1,1, new Color(255,0,0)),
      new GradientPaint(0,0, Color.gray, 1,1, Color.cyan),  
      new GradientPaint(0,0, new Color(0xFFFF00), 1,1, new Color(0x0000FF)),  
      new GradientPaint(0,0, Color.yellow, 1,1, Color.blue),  
      new GradientPaint(0,0, Color.red, 1,1, Color.white),  
      new GradientPaint(0,0, Color.black, 1,1, Color.white),  
      new GradientPaint(0,0, Color.black, 1,1, Color.white),  
      new GradientPaint(0,0, Color.black, 1,1, Color.white),  
      new GradientPaint(0,0, Color.black, 1,1, Color.white),  
      new GradientPaint(0,0, new Color(0,255,0), 1,1, Color.yellow),  
      new GradientPaint(0,0, new Color(0,255,0), 1,1, new Color(0x0000FF)),  
      new GradientPaint(0,0, Color.yellow, 1,1, new Color(0x0000FF)),  
    };
    
    String[] testGradFileNames = { 
        "JFreeChartUtilsTestGradColor.xml", //$NON-NLS-1$
    };

    
    for (int i = 0; i < testGradFileNames.length; i++) {
      ChartDocumentContext cdc = ChartFactory.generateChart(getClass().getResource(testGradFileNames[i])); 
      assertNotNull(cdc);
      ChartDocument cd = cdc.getChartDocument();
      assertNotNull(cd);
      
      List seriesList = cd.getSeriesChartElements();
      if (seriesList.size() == 0) {        
        fail("The Series list should never be empty."); //$NON-NLS-1$       
      }
      
      for (int seriesCounter = 0; seriesCounter < seriesList.size(); seriesCounter++) {
        ChartElement currElement = (ChartElement)seriesList.get(seriesCounter);
        GradientPaint gotGradientPaint = JFreeChartUtils.getGradientPaint(currElement);
        if (seriesCounter==0) {
          assertNull(gotGradientPaint);
        } else {
          assertNotNull(gotGradientPaint);
          assertEquals("Counter# "+seriesCounter+" Color#1:", expectedValues[seriesCounter].getColor1(), gotGradientPaint.getColor1()); //$NON-NLS-1$//$NON-NLS-2$
          assertEquals("Counter# "+seriesCounter+" Color#2:", expectedValues[seriesCounter].getColor2(), gotGradientPaint.getColor2()); //$NON-NLS-1$//$NON-NLS-2$
          assertEquals("Counter# "+seriesCounter+" Pos#1:", gotGradientPaint.getPoint1(), expectedValues[seriesCounter].getPoint1()); //$NON-NLS-1$//$NON-NLS-2$
          assertEquals("Counter# "+seriesCounter+" Pos#2:", gotGradientPaint.getPoint2(), expectedValues[seriesCounter].getPoint2()); //$NON-NLS-1$//$NON-NLS-2$
        }
      }
    }
  }
  
  public void testGetStandardGradientPaint() throws ResourceException {
    String[] testGradFileNames = { 
        "StandardGradientPaint.xml", //$NON-NLS-1$
    };
    
    GradientPaintTransformType[] expectedValues = new GradientPaintTransformType[] {
      null,
      null,
      null,
      GradientPaintTransformType.HORIZONTAL,
      GradientPaintTransformType.VERTICAL,
      GradientPaintTransformType.CENTER_HORIZONTAL,
      GradientPaintTransformType.CENTER_VERTICAL,
    };
    
    for (String fileName : testGradFileNames) {
      ChartDocumentContext cdc = ChartFactory.generateChart(getClass().getResource(fileName)); 
      assertNotNull(cdc);
      ChartDocument cd = cdc.getChartDocument();
      assertNotNull(cd);
      
      List seriesList = cd.getSeriesChartElements();
      if (seriesList.size() == 0) {        
        fail("The Series list should never be empty."); //$NON-NLS-1$       
      }
      
      for (int i=0; i< seriesList.size(); i++){
        ChartElement ce = (ChartElement)seriesList.get(i);
        if (i == 0 || i == 1 || i == 2) {
          assertNull(JFreeChartUtils.getStandardGradientPaintTrans(ce));
        } else {          
          assertEquals(expectedValues[i], JFreeChartUtils.getStandardGradientPaintTrans(ce).getType());
        }
      }      
    }    
  }    
}