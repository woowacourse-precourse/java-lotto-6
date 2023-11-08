package lotto.controller;

import java.io.Closeable;

public interface Reader extends Closeable {
    String readLine();

    void close();
}
