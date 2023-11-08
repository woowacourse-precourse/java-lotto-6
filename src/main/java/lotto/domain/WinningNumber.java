package lotto.domain;

import lotto.utils.Message;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private Lotto lotto;

    public WinningNumber(String input) {
        this.lotto = validate(input);
    }

    private Lotto validate(String input) {
        List<String> inputNumbers = Arrays.asList(input.split(","));
        try {
            List<Integer> list = inputNumbers.stream()
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(list);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INPUT_INTERGER_ERROR.getMessage());
        }
    }

    public Lotto getLotto() {
        return lotto;
    }
}
