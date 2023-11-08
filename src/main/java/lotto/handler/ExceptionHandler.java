package lotto.handler;

import camp.nextstep.edu.missionutils.Console;

public class ExceptionHandler {
    public static void handle(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public static void checkNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException("String is null or empty. \n └─ errorVar : " + input);
        }
    }

    public static void checkNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format. \n └─ errorVar : " + input);
        }
    }
}
