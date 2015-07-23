package com.flight.api.util;

import com.flight.api.core.Airlines;
import com.flight.api.core.Route;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Map;

public class CSVUtilTest {
    Map<Route, Airlines> routeDict = CSVUtil.csvToDict();

    @Test
    public void testCSVToDict() {
        Assert.assertNotNull(routeDict);
    }
}
