package util;

import java.io.ByteArrayInputStream;

public class TestUtil {
    public static void setInput(String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
