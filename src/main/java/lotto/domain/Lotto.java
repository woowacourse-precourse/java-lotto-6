package lotto.domain;

import static java.util.Collections.nCopies;
import static lotto.constant.LottoConstant.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.InvalidInput;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> winningStatistics(int bonusNumber, List<List<Integer>> myLottoNumbers) {
        int initSzie = LOTTO_SIZE.getValue();
        int initNum = 0;

        List<Integer> statistics = new ArrayList<>(nCopies(initSzie, initNum));

        for (List<Integer> myLottoNumber : myLottoNumbers) {
            int sameNumberScore = getSameNumberScore(bonusNumber, myLottoNumber);
            int index = sameNumberScore - 2;
            statistics.set(index, statistics.get(index) + 1);
        }

        return statistics;
    }

    private void validate(List<Integer> numbers) {
        InvalidInput invalidInput = new InvalidInput();

        invalidInput.sizeExceededException(numbers);
        invalidInput.duplicateNumberException(numbers);
        invalidInput.outOfRangeException(numbers);
    }

    private int getSameNumberScore(int bonusNumber, List<Integer> myLottoNumber) {
        int sameNumberCount = (int) myLottoNumber.stream()
                .filter(numbers::contains)
                .count();

        int score = sameNumberCount;

        if (hasBonusNumber(bonusNumber, myLottoNumber) && sameNumberCount == 5 || sameNumberCount == 6) {
            score++;
        }
        return score;
    }

    private Boolean hasBonusNumber(int bonusNumber, List<Integer> myLottoNumber) {
        if (myLottoNumber.contains(bonusNumber)) {//보너스 볼 일치
            return true;
        }

        return false;
    }

}
