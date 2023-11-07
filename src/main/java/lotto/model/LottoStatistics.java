package lotto.model;

public class LottoStatistics {
    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private int threeNumbersMatch = 0;
    private int fourNumbersMatch = 0;
    private int fiveNumbersMatch = 0;
    private int fiveNumbersAndBonusNumberMatch = 0;
    private int sixNumbersMatch = 0;

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

    private void checkMatch(int count, boolean lottoHasBonusNumber) {
        if (count == LottoRank.THREE_MATCH.getMatchCount()) {
            threeNumbersMatch++;
        }
        if (count == LottoRank.FOUR_MATCH.getMatchCount()) {
            fourNumbersMatch++;
        }
        if (count == LottoRank.FIVE_MATCH.getMatchCount() && lottoHasBonusNumber == false) {
            fiveNumbersMatch++;
        }
        if (count == LottoRank.FIVE_AND_BONUS_MATCH.getMatchCount() && lottoHasBonusNumber == true) {
            fiveNumbersAndBonusNumberMatch++;
        }
        if (count == LottoRank.SIX_MATCH.getMatchCount()) {
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
