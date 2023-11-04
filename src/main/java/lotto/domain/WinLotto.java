package lotto.domain;

import java.util.List;

public class WinLotto {

    //todo: condition 묶어서 관리?
    private static final Integer LOTTO_COUNT = 6;
    private static final Integer MINIMUM_LOTTO_RANGE = 1;
    private static final Integer MAXIMUM_LOTTO_RANGE = 45;

    private final List<Integer> numbers;
    private final Integer bonus;

    public WinLotto(List<Integer> numbers, Integer bonus) {
        validate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers, Integer bonus) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }

        if (numbers.stream().allMatch(number -> (number >= MINIMUM_LOTTO_RANGE && number <=45))) {
            throw new IllegalArgumentException();
        }

        //todo: 중복값 검증
    }





}
