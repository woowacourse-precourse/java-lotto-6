package lotto.io;

public interface Writer {
    void write(String contextWithOutLine);
    void writeLine(String context);
    void writeFormat(String format, Object... args);
}
