package lotto.Domain;

import java.util.List;

public class WinningStatistics {

    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private int countMatchingNumbers(Lotto lotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int countMatchingAndBonus(Lotto lotto) {
        int count = countMatchingNumbers(lotto);
        if (count == 5 && hasBonusNumber(lotto)) {
            return 5;
        }
        return count;
    }

    public int countMatchingOnly(Lotto lotto) {
        return countMatchingNumbers(lotto);
    }

    public int countMatchingThree() {
        int countThree = 0;
        for (Lotto lotto : lottos) {
            if (countMatchingOnly(lotto) == 3) {
                countThree++;
            }
        }
        return countThree;
    }

    public int countMatchingFour() {
        int countFour = 0;
        for (Lotto lotto : lottos) {
            if (countMatchingOnly(lotto) == 4) {
                countFour++;
            }
        }
        return countFour;
    }

    public int countMatchingFive() {
        int countFive = 0;
        for (Lotto lotto : lottos) {
            if (countMatchingOnly(lotto) == 5 && !(hasBonusNumber(lotto))) {
                countFive++;
            }
        }
        return countFive;
    }

    public int countMatchingAll() {
        int countAll = 0;
        for (Lotto lotto : lottos) {
            if (countMatchingOnly(lotto) == 6) {
                countAll++;
            }
        }
        return countAll;
    }

    public int countMatchingFiveBonus() {
        int count = 0;
        for (Lotto lotto : lottos) {
            if (countMatchingAndBonus(lotto) == 5) {
                count++;
            }
        }
        return count;
    }

    public double calculateTotalWinningRate() {
        int totalPrize = countMatchingThree() * WinningRank.THREE.getPrize() +
                countMatchingFour() * WinningRank.FOUR.getPrize() +
                countMatchingFive() * WinningRank.FIVE.getPrize() +
                countMatchingFiveBonus() * WinningRank.FIVE_BONUS.getPrize() +
                countMatchingAll() * WinningRank.ALL.getPrize();
        return (double) totalPrize / (lottos.size() * 1000) * 100;
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원) - " + countMatchingThree() + "개\n" +
                "4개 일치 (50,000원) - " + countMatchingFour() + "개\n" +
                "5개 일치 (1,500,000원) - " + countMatchingFive() + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + countMatchingFiveBonus() + "개\n" +
                "6개 일치 (2,000,000,000원) - " + countMatchingAll() + "개";
    }
}
