package lotto.domain;

import static java.util.Collections.nCopies;
import static lotto.constant.LottoConstant.MAX_SCORE;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.InvalidInput;

public class Lotto {
    private final static int INIT = 0;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> winningStatistics(int bonusNumber, List<List<Integer>> myLottoNumbers) {
        List<Integer> statistics = new ArrayList<>(nCopies(MAX_SCORE.getValue() + 1, INIT));

        for (List<Integer> myLottoNumber : myLottoNumbers) {
            int score = getScore(bonusNumber, myLottoNumber);
            statistics.set(score, statistics.get(score) + 1);
        }

        return statistics;
    }

    private void validate(List<Integer> numbers) {
        InvalidInput invalidInput = new InvalidInput();

        invalidInput.sizeExceededException(numbers);
        invalidInput.duplicateNumberException(numbers);
        invalidInput.outOfRangeException(numbers);
    }

    private int getScore(int bonusNumber, List<Integer> myLottoNumber) {
        int score = getSameNumberCount(myLottoNumber);

        if (hasBonusNumber(bonusNumber, myLottoNumber) && score == 5 || score == 6) {
            score++;
        }

        return score;
    }

    private int getSameNumberCount(List<Integer> myLottoNumber) {
        long sameNumberCount = myLottoNumber.stream()
                .filter(numbers::contains)
                .count();

        return (int)sameNumberCount;
    }

    private Boolean hasBonusNumber(int bonusNumber, List<Integer> myLottoNumber) {
        if (myLottoNumber.contains(bonusNumber)) {//보너스 볼 일치
            return true;
        }

        return false;
    }

}
