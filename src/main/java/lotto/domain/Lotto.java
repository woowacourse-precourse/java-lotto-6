package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.Message;
import lotto.utils.Checker;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Checker.validateSize(numbers, GameSetting.TICKET_SIZE.getValue());
        Checker.validateRange(numbers, GameSetting.START_NUMBER.getValue(), GameSetting.END_NUMBER.getValue());
        Checker.validateUnique(numbers);
    }

    // TODO: 추가 기능 구현
}
