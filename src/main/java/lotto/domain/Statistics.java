package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.WinningLotto;

public class Statistics {

    private final Purchase purchasedLotto;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int[] rank = {0, 0, 0, 0, 0, 0, 0};

    public Statistics(Purchase purchasedLotto, WinningLotto winningNumbers) {
        this.purchasedLotto = purchasedLotto;
        this.winningNumbers = winningNumbers.getWinningNumbers();
        this.bonusNumber = winningNumbers.getBonusNumber();
    }

    public void matchLotto() {
        for (Lotto lotto : purchasedLotto.getPurchasedLotto()) {
            rank[matchCount(lotto)]++;
        }
    }

    public int matchCount(Lotto lotto) {
        int matchCount = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 5 && checkBonus(lotto)) {
            matchCount = matchCount + 2;
        }

        return matchCount;
    }

    public boolean checkBonus(Lotto lotto) {
        for (int number : lotto.getNumbers()) {
            if (this.bonusNumber == number) {
                return true;
            }
        }
        return false;
    }

    public void getRank() {
        System.out.println(Arrays.toString(rank));
    }
}
