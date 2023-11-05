package lotto.model;

public class WinningNumbers {

    private final WinningNumbersData winningNumbersData;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumbersData winningNumbersData, BonusNumber bonusNumber) {
        validateBonusNumber(winningNumbersData, bonusNumber);
        this.winningNumbersData = winningNumbersData;
        this.bonusNumber = bonusNumber;
    }

    public Rank findRank(Lotto lotto) {
        return Rank.find(winningNumbersData.countMatchingNumber(lotto), bonusNumber.isEqualToBonus(lotto));
    }

    private void validateBonusNumber(WinningNumbersData winningNumbersData, BonusNumber bonusNumber) {
        if (winningNumbersData.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복이 되면 안 됩니다,");
        }
    }
}
