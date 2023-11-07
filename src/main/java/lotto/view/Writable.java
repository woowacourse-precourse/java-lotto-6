package lotto.view;

public interface Writable {
    void printLine(String message);

    void printByFormat(String format, Object... args);
}
