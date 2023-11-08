package lotto.view;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String BOUNDARY_LINE = "--------------------------------------------------------";
    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
        System.out.println(BOUNDARY_LINE);
        System.out.println();
    }
}
