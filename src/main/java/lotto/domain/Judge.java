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

    public static boolean compareBonusNumber(Lotto givenInput, LottoBonus Bonus) {
        List<Integer> givenNumbers = givenInput.getNumbers();
        int bonusNumber = Bonus.getNumber();
        if (givenNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

}
