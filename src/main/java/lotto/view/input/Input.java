package lotto.view.input;

public interface Input {
    String getInput();
    default void println() {
        System.out.println();
    }
}
