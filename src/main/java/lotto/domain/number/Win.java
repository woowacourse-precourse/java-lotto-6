package lotto.domain.number;

import static lotto.utils.LottoConstant.LOTTO_NUMBER_COUNT;

import java.util.List;
import java.util.Objects;
import lotto.domain.result.Grade;

public class Win {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public Win(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Grade match(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int matchCount = 0;
        int bonusMatchCount = 0;

        for (int index = 0; index < LOTTO_NUMBER_COUNT; index++) {
            if (Objects.equals(this.numbers.get(index), lottoNumbers.get(index))) {
                matchCount++;
            }
        }

        if (matchCount == 5 && lottoNumbers.contains(bonusNumber)) {
            bonusMatchCount++;
        }

        return Grade.of(matchCount, bonusMatchCount);
    }
}
