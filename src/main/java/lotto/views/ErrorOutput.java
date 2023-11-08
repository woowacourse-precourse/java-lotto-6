package lotto.views;

public class ErrorOutput {
    public static final String ERROR_TAG = "[ERROR]";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_TAG + " " + errorMessage);
    }
}
