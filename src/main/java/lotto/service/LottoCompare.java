package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;

public class LottoCompare {
    public HashMap<Integer, List<Integer>> compareLottoToNumber(HashMap<Integer, Lotto> allLotto,
                                                                WinningNumber winningNumber, BonusNumber bonusNumber) {
        HashMap<Integer, List<Integer>> countSameNumbers = new HashMap<>();
        int countWinningInLotto;
        int countBonusInLotto;

        for (int key : allLotto.keySet()) {
            List<Integer> randomLottoNumber = allLotto.get(key).getLotto();
            countWinningInLotto = compareLottoToWinningNumber(randomLottoNumber, winningNumber.getWinningNumber());
            countBonusInLotto = compareLottoToBonusNumber(randomLottoNumber, bonusNumber.getBonusNumber());

            countSameNumbers.put(key, List.of(countWinningInLotto, countBonusInLotto));
        }

        return countSameNumbers;
    }

    private int compareLottoToWinningNumber(List<Integer> lottoNumber, List<Integer> winningNumber) {
        int countSameNumber = 0;

        for (int number : lottoNumber) {
            if (winningNumber.contains(number)) {
                countSameNumber++;
            }
        }

        return countSameNumber;
    }

    private int compareLottoToBonusNumber(List<Integer> lottoNumber, int bonusNumber) {
        int countSameNumber = 0;

        for (int number : lottoNumber) {
            if (number == bonusNumber) {
                countSameNumber++;
            }
        }

        return countSameNumber;
    }
}
