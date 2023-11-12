package lotto.exception;

import static lotto.exception.ExceptionMessage.*;

public class ExceptionMessageBuilder {
    private ExceptionMessageBuilder(){}

    public static String build(ExceptionMessage exceptionMessage){
        return String.join(" ", ERROR_LOG.getMessage(), exceptionMessage.getMessage());
    }

    public static String build(String exceptionMessage){
        return String.join(" ", ERROR_LOG.getMessage(), exceptionMessage);
    }
}
