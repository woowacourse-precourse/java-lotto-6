package lotto.domain.number;

import static lotto.utils.LottoConstant.LOTTO_NUMBER_COUNT;

import java.util.List;
import lotto.domain.result.Grade;

public class Winning {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public static Winning of(List<Integer> numbers, int bonusNumber) {
        return new Winning(numbers, bonusNumber);
    }

    private Winning(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Grade match(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int matchCount = 0;
        int bonusMatchCount = 0;

        for (int index = 0; index < LOTTO_NUMBER_COUNT; index++) {
            if (this.numbers.contains(lottoNumbers.get(index))) {
                matchCount++;
            }
        }

        if (matchCount == 5 && lottoNumbers.contains(bonusNumber)) {
            bonusMatchCount++;
        }

        return Grade.of(matchCount, bonusMatchCount);
    }
}
