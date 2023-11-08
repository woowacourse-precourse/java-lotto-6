package lotto.utils.view;

public class Output {

    public static final String ERROR_PRIFIX_MESSAGE = "[ERROR] ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_PRIFIX_MESSAGE + message);
    }
}
