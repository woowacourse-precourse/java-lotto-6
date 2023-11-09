package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.controller.Validator;
import lotto.util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        duplicateCheck.addAll(numbers);
        if (duplicateCheck.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.OVER_SIZE);
        }
        for(int number : numbers){
            Validator.isValidRange(number);
        }

    }

    // TODO: 추가 기능 구현

    public List<Integer> getLottoNumber() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}


