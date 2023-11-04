package lotto;

import camp.nextstep.edu.missionutils.Console;

class Input {
    static Integer inputMoney() {
        String raw = Console.readLine();
        Validation.inputMoneyExceptionCheck(raw);
        return Integer.parseInt(raw);
    }
}