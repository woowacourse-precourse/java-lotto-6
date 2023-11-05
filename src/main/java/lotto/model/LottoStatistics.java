package lotto.model;

public class LottoStatistics {
    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private int threeNumbersMatch;
    private int fourNumbersMatch;
    private int fiveNumbersMatch;
    private int fiveNumbersAndBonusNumberMatch;
    private int sixNumbersMatch;

    public LottoStatistics(Lottos lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public void compareLottosWithWinningNumbers() {
        for (Lotto lotto : lottos) {
            compareLottoWithWinningNumbers(lotto);
        }
    }

    private void compareLottoWithWinningNumbers(Lotto lotto) {
        int count = 0;
        boolean lottoHasBonusNumber = false;

        for (int number : lotto) {
            if (winningNumbers.getWinningNumbers().contains(number)) {
                count++;
            }
        }

        if (count == 5) {
            lottoHasBonusNumber = hasBonusNumber(lotto);
        }

        checkMatch(count, lottoHasBonusNumber);
    }

    private boolean hasBonusNumber(Lotto lotto) {

        for (int number : lotto) {
            if (winningNumbers.getBonusNumber() == number) {
                return true;
            }
        }
        return false;
    }

    public void checkMatch(int count, boolean lottoHasBonusNumber) {
        if (count == 3) {
            threeNumbersMatch++;
        }
        if (count == 4) {
            fourNumbersMatch++;
        }
        if (count == 5) {
            fiveNumbersMatch++;
        }
        if (count == 5 && lottoHasBonusNumber == true) {
            fiveNumbersAndBonusNumberMatch++;
        }
        if (count == 6) {
            sixNumbersMatch++;
        }
    }

    public int getThreeNumbersMatch() {
        return threeNumbersMatch;
    }

    public int getFourNumbersMatch() {
        return fourNumbersMatch;
    }

    public int getFiveNumbersMatch() {
        return fiveNumbersMatch;
    }

    public int getFiveNumbersAndBonusNumberMatch() {
        return fiveNumbersAndBonusNumberMatch;
    }

    public int getSixNumbersMatch() {
        return sixNumbersMatch;
    }
}
