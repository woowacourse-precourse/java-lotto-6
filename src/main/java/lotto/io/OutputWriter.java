package lotto.io;

public interface OutputWriter {

    void writeLine(final String message);

    void writeLineWithoutNewLine(final String rankMessage);
}
