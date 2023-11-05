package lotto.message;

public class ErrorMessageFormatter {

    public static String ERROR_FLAG = "[ERROR] ";

    public static String errorMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ERROR_FLAG)
            .append(message);

        return sb.toString();
    }

}
