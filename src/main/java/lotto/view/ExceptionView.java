package lotto.view;

public class ExceptionView {
    public static final String ERROR_MESSAGE = "[ERROR] ";

    public void printException(String exceptionMessage) {
        System.out.println(ERROR_MESSAGE + exceptionMessage);
        System.out.println();
    }
}
