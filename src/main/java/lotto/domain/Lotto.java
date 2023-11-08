package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Integer matchedLottoCount(List<Integer> lottoNumbers) {
        Integer match = 0;
        for (Integer lottoNumber: lottoNumbers) {
            if (numbers.contains(lottoNumber)) {
                match++;
            }
        }
        return match;
    }

    public Boolean didMatchBonus(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
