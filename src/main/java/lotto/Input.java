package lotto;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

class Input {
    static Long inputMoney() {
        String raw = Console.readLine();
        Validation.inputMoneyExceptionCheck(raw);
        return Long.parseLong(raw);
    }

    static Lotto inputWinnerNumber() {
        String raw = Console.readLine();
        Validation.inputWinnerNumberExceptionCheck(raw);
        List<Integer> numbers = Arrays.stream(raw.split(",")).map(Integer::parseInt).toList();
        Lotto winnerTicket = new Lotto(numbers);
        return winnerTicket;
    }

    public static Integer inputBonusNumber(Lotto winnerTicket) {
        String raw = Console.readLine();
        Validation.inputBonusNumberExceptionCheck(raw, winnerTicket);
        return Integer.parseInt(raw);
    }
}