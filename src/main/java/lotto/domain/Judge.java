package lotto.domain;

import java.util.List;

public class Judge {
    private Judge() {
    }

    public static int compareWinningNumbers(Lotto lottoWinningNumbers, Lotto lottoRandomNumbers) {
        int count = 0;
        List<Integer> winningNumbers = lottoWinningNumbers.getNumbers();
        List<Integer> randomNumbers = lottoRandomNumbers.getNumbers();

        for (Integer number : winningNumbers) {
            if (randomNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static boolean compareBonusNumber(Lotto lottoWinningNumbers, LottoBonus lottoBonus) {
        
    }
}
