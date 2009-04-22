package org.pentaho.chart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GraphPlot extends Plot implements Serializable {
  
  Number minValue = null;
  Number maxValue = null;
  
  StyledText xAxisLabel = new StyledText();
  StyledText yAxisLabel = new StyledText();
  
  public StyledText getXAxisLabel() {
    return xAxisLabel;
  }
  
  public void setXAxisLabel(StyledText xAxisLabel) {
    this.xAxisLabel = xAxisLabel;
  }
  
  public StyledText getYAxisLabel() {
    return yAxisLabel;
  }
  
  public void setYAxisLabel(StyledText yAxisLabel) {
    this.yAxisLabel = yAxisLabel;
  }

  public Number getMinValue() {
    return minValue;
  }

  public void setMinValue(Number minValue) {
    this.minValue = minValue;
  }

  public Number getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(Number maxValue) {
    this.maxValue = maxValue;
  }

}
