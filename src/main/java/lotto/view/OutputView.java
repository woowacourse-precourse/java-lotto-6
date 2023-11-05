package lotto.view;

public class OutputView {
    public static void notifyErrorMessage(String errorMessage) {
        String errorPhrase = "[ERROR] " + errorMessage;
        System.out.println(errorPhrase);
    }
}
