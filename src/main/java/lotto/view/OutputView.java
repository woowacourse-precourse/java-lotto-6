package lotto.view;

public class OutputView {

    public void println(String text) {
        System.out.println(text);
    }

    public void printErrorMessage(Exception error) {
        println(error.getMessage());
    }
}
