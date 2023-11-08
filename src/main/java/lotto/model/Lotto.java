package lotto.model;

import lotto.controllers.LottoStoreManager;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}


