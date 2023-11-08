package lotto.domain.winning;

import static lotto.utils.LottoConstant.LOTTO_NUMBERS_SIZE;

import java.util.List;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.Lotto;
import lotto.utils.IntegerConstant;

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

        int matchCount = matchLottoNumbers(lottoNumbers);
        int bonusMatchCount = matchBonusNumber(lottoNumbers);

        return Grade.of(matchCount, bonusMatchCount);
    }

    private int matchLottoNumbers(List<Integer> lottoNumbers) {
        int matchCount = IntegerConstant.ZERO;

        for (int index = IntegerConstant.ZERO; index < LOTTO_NUMBERS_SIZE; index++) {
            if (this.numbers.contains(lottoNumbers.get(index))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private int matchBonusNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            return IntegerConstant.ONE;
        }

        return IntegerConstant.ZERO;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
