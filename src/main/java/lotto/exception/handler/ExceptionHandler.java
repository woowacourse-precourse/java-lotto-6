package lotto.exception.handler;

import lotto.constant.OutputMessage;

import static lotto.constant.OutputMessage.EXCEPTION_PREFIX;

public class ExceptionHandler {
    public void handleException(Exception e) {
        System.out.println(EXCEPTION_PREFIX+" "+e.getMessage());
    }
}
