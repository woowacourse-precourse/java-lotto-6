package lotto;

import static lotto.input.constant.Constant.BONUS_NUMBER_INDEX;

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
        if (count == 6) {
            Result.FIRST.addValue();
        }
        if (count == 5 && userNumbers.contains(winningNumbers.get(BONUS_NUMBER_INDEX))) {
            Result.SECOND.addValue();
        }
        if (count == 5 && !userNumbers.contains(winningNumbers.get(BONUS_NUMBER_INDEX))) {
            Result.THIRD.addValue();
        }
        if (count == 4) {
            Result.FOURTH.addValue();
        }
        if (count == 3) {
            Result.FIFTH.addValue();
        }
    }
}
