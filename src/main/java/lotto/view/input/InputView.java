package lotto.view.input;

public interface InputView {
    String readLine();
    void printErrorMessage(RuntimeException e);
    void newLine();
}
