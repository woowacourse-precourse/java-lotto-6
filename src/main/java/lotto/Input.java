package lotto;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

class Input {
    static Integer inputMoney() {
        String raw = Console.readLine();
        Validation.inputMoneyExceptionCheck(raw);
        return Integer.parseInt(raw);
    }

    static Lotto inputWinnerNumber() {
        String raw = Console.readLine();
        Validation.inputWinnerNumberExceptionCheck(raw);
        List<Integer> numbers = Arrays.stream(raw.split(",")).map(Integer::parseInt).toList();
        Lotto winnerTicket = new Lotto(numbers);
        return winnerTicket;
    }
}