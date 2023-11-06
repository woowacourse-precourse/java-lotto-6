package lotto;

public class ErrorLogger {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static void log(IllegalArgumentException e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void exceptionLog(Exception e){
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
