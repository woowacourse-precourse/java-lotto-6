package lotto;

import camp.nextstep.edu.missionutils.Console;

class Input {
    private Integer inputMoney() {
        String raw = Console.readLine();
        moneyExceptionCheck(raw);
        return Integer.parseInt(raw);
    }

    private void moneyExceptionCheck(String raw) {
        emptyCheck(raw);
        nanCheck(raw);
        naturalNumberCheck(raw);
        devide1000Check(raw);
    }

    private void emptyCheck(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException();
        }
    }

    private void naturalNumberCheck(String raw) {
        try {
            if (Integer.parseInt(raw) <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void nanCheck(String raw) {
        try {
            Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void devide1000Check(String raw) {
        try {
            if (Integer.parseInt(raw) % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}