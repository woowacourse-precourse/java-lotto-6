package lotto.util;

public class Log {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public Log() {
    }

    public void error(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public String info(String input) {
        return input;
    }
}
