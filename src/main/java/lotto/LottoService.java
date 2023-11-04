package lotto;

import static lotto.input.constant.Constant.BONUS_NUMBER_INDEX;
import static lotto.input.constant.Constant.FIFTH_STRIKE_COUNT;
import static lotto.input.constant.Constant.FIRST_STRIKE_COUNT;
import static lotto.input.constant.Constant.FOURTH_STRIKE_COUNT;
import static lotto.input.constant.Constant.SECOND_THIRD_STRIKE_COUNT;

import java.util.List;
import lotto.input.Result;

public class LottoService {

    private final List<Integer> winningNumbers;

    private final List<Lotto> lottos;


    public LottoService(List<Integer> winningNumbers, List<Lotto> lottos) {
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;
    }

    public void compareWinningNumbers() {
        for (Lotto lotto : lottos) {
            int count = 0;
            List<Integer> userNumbers = lotto.getNumbers();
            count = getCount(userNumbers, count);
            extractedResult(count, userNumbers);
        }
    }

    private int getCount(List<Integer> userNumbers, int count) {
        for (int i = 0; i < 6; i++) {
            if (userNumbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private void extractedResult(int count, List<Integer> userNumbers) {
        if (count == FIRST_STRIKE_COUNT) {
            Result.FIRST.addValue();
        }
        if (count == SECOND_THIRD_STRIKE_COUNT && isBounsNumberStrike(userNumbers)) {
            Result.SECOND.addValue();
        }
        if (count == SECOND_THIRD_STRIKE_COUNT && !isBounsNumberStrike(userNumbers)) {
            Result.THIRD.addValue();
        }
        if (count == FOURTH_STRIKE_COUNT) {
            Result.FOURTH.addValue();
        }
        if (count == FIFTH_STRIKE_COUNT) {
            Result.FIFTH.addValue();
        }
    }

    private boolean isBounsNumberStrike(List<Integer> userNumbers) {
        return userNumbers.contains(winningNumbers.get(BONUS_NUMBER_INDEX));
    }
}
