package lotto.handler;

import camp.nextstep.edu.missionutils.Console;

public class ExceptionHandler {
    public static void handle(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
