package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ExceptionMessage;
import lotto.constant.Game;
import lotto.constant.RegexValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Game.TOTAL_PICK.getNum()) {
            throw new IllegalArgumentException(ExceptionMessage.COUNT.toString());
        }

        // 중복 검사
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != Game.TOTAL_PICK.getNum()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE.toString());
        }

        // 번호 유효성 검사
        for (int number : numbers) {
            RegexValidator.LOTTO_NUMBER.validate(String.valueOf(number));
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
