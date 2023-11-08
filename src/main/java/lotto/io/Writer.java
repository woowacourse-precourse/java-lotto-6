package lotto.io;

public interface Writer {
    void writeLine(String context);
    void writeFormat(String format, Object... args);
}
