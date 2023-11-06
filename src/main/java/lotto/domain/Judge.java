package lotto.domain;

import java.util.List;

public class Judge {
    private Judge() {
    }

    public static int compareWinningNumbers(Lotto lottoWinningNumbers, Lotto lottoRandomNumbers) {
        int matchCount = 0;
        List<Integer> winningNumbers = lottoWinningNumbers.getNumbers();
        List<Integer> randomNumbers = lottoRandomNumbers.getNumbers();

        for (Integer number : winningNumbers) {
            if (randomNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static boolean compareBonusNumber(Lotto lottoWinningNumbers, LottoBonus lottoBonus) {
        List<Integer> winningNumbers = lottoWinningNumbers.getNumbers();
        int bonusNumber = lottoBonus.getNumber();
        if (winningNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

}
