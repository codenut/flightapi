package com.flight.api.util;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by michael on 7/23/15.
 */
public class Helper {
    public static void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

    public static InputStream getInputStream(String filename) {
        return new Helper().getClass().getClassLoader().getResourceAsStream(filename);
    }

    public static String getAbsolutePath(String filename) {
        return new Helper().getClass().getClassLoader().getResource(filename).getPath();
    }

}
