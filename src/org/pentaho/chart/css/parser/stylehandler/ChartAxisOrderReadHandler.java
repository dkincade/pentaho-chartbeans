/*
 * Copyright 2007 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the Mozilla Public License, Version 1.1, or any later version. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.mozilla.org/MPL/MPL-1.1.txt. The Original Code is the Pentaho 
 * BI Platform.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
 *
 * Created 3/25/2008 
 * @author Ravi Hasija 
 */

package org.pentaho.chart.css.parser.stylehandler;

import org.pentaho.reporting.libraries.css.model.StyleKey;
import org.pentaho.reporting.libraries.css.parser.CSSValueReadHandler;
import org.pentaho.reporting.libraries.css.values.CSSNumericType;
import org.pentaho.reporting.libraries.css.values.CSSNumericValue;
import org.pentaho.reporting.libraries.css.values.CSSValue;
import org.w3c.css.sac.LexicalUnit;

/**
 * The style parser for the <code>-x-pentaho-chart-axis-type-order</code> style.
 *
 * @author Ravi Hasija
 */
public class ChartAxisOrderReadHandler implements CSSValueReadHandler
{
  public ChartAxisOrderReadHandler() {    
  }

  /**
   * Parses the LexicalUnit and returns the CSSValue 
   *
   * @param value
   * @return
   */
  public CSSValue createValue(final StyleKey name, final LexicalUnit value)
  {
    CSSNumericValue numValue = null;
    
    if (value.getLexicalUnitType() == LexicalUnit.SAC_INTEGER) {
      numValue = CSSNumericValue.createValue(CSSNumericType.NUMBER, value.getIntegerValue());
    } 
    
    return numValue;
  }
}