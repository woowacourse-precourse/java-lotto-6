package lotto.model;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validaLottoOversizeAndDuplicatedNumber(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validaLottoOversizeAndDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> pickSixLottoNumber = new HashSet<>();
        pickSixLottoNumber.addAll(numbers);
        if (pickSixLottoNumber.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> pickSixLottoNumber() {
        final int MIN_LOTTO_NUMBER = 1;
        final int MAX_LOTTO_NUMBER = 45;
        final int LOTTO_NUMBER_COUNT = 6;
        return pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
    }

    public void sortAscending(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}


