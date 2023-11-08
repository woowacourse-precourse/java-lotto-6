package lotto.view.printer;

public interface Printer {
    void printLine(String message);

    void printEmptyLine();

    void printExceptionMessage(String message);
}
