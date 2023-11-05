package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.WinningLotto;
import lotto.constant.Constant;

public class Statistics {

    private final Purchase purchasedLotto;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int[] rank = {0, 0, 0, 0, 0, 0, 0, 0};

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
        System.out.printf("%s%d개\n", Constant.fourth, rank[3]);
        System.out.printf("%s%d개\n", Constant.third, rank[4]);
        System.out.printf("%s%d개\n", Constant.second, rank[5]);
        System.out.printf("%s%d개\n", Constant.secondWithBonus, rank[7]);
        System.out.printf("%s%d개\n", Constant.first, rank[6]);
    }
}
