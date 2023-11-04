package lotto.exception;

import static lotto.exception.ExceptionMessage.*;

public final class ExceptionMessageBuilder {
    private ExceptionMessageBuilder(){}

    public static String build(ExceptionMessage exceptionMessage){
        return String.join(" ", ERROR_LOG.getMessage(), exceptionMessage.getMessage());
    }
}
