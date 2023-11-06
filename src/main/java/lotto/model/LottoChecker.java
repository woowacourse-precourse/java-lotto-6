package lotto.model;

import java.util.List;

public class LottoChecker {

    public int[] createResult(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] result = new int[6];
        for (Lotto lotto : lottos.getLottos()) {
            int index = checkAnswer(lotto.compareLottoNumbers(winningNumbers),
                    lotto.compareBonusNumber(bonusNumber));
            result[index]++;
        }
        return result;
    }


    public int checkAnswer(long count, boolean bonus) {
        int index = 0;

        if (count == 3) {
            index = 1;
        }
        if (count == 4) {
            index = 2;
        }
        if (count == 5 && !bonus) {
            index = 3;
        }
        if (count == 5 && bonus) {
            index = 4;
        }
        if (count == 6 && !bonus) {
            index = 5;
        }
        return index;
    }

}
