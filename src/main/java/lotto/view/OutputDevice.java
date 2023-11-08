package lotto.view;

public interface OutputDevice {
    void printLine(String message);

    void printByFormat(String format, Object... args);
}
