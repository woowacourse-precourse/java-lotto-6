package lotto.common.log;

public class Logger {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n\n";

    private Logger() {
    }

    public static void log(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
