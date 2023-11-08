package lotto.view.output;

public interface Output {
    void getOutput();
    default void println() {
        System.out.println();
    }
}
