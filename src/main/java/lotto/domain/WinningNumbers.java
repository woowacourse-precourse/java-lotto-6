package lotto.domain;

public class WinningNumbers {

    private final LottoNumbers lottoNumbers;
    private final int bonusNumber;

    public WinningNumbers(LottoNumbers lottoNumbers, int bonusNumber) {
        validateDuplicated(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicated(LottoNumbers lottoNumbers, int bonusNumber) {
        if (lottoNumbers.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getValue());
        }
    }

    public Rank announceRanking(Lotto lotto) {
        int matchingNumberCounts = lotto.compareNumbersWithWinningNumber(this.lottoNumbers);
        boolean hasBonusNumber = lotto.contains(this.bonusNumber);
        return Rank.of(matchingNumberCounts, hasBonusNumber);
    }
}
