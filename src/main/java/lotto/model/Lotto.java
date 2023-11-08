package lotto.model;

import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
        InputValidator.checkUserInputDuplicated(numbers);
    }

    // TODO: 추가 기능 구현
    public int countMatchEachLotto(List<Integer> eachLotto) {
        int match = 0;

        for (int i=0;i<LOTTO_LENGTH;i++) {
            if (eachLotto.contains(numbers.get(i))) {
                match++;
            }
        }

        return match;
    }

    public boolean checkLottoContainBonus(int bonus) {
        return numbers.contains(bonus);
    }

}
