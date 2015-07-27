package com.flight.api.util;

import com.flight.api.core.Airlines;
import com.flight.api.core.Route;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Map;

public class UtilTest {
    Map<Route, Airlines> routeDict = Util.csvToDict();

    @Test
    public void testCSVToDict() {
        Assert.assertNotNull(routeDict);
    }
}
