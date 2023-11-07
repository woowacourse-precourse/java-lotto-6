package lotto.printer;

public interface GamePrinter {

    void print(Object obj);

    void print(String message, Object... args);

    default void newLine() {
        print("");
    }
}
