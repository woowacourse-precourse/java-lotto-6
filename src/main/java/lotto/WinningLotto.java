package lotto;

public class WinningLotto {
    private static final String NON_OVERLAPPING_NUMBER_REQUEST_MESSAGE = "보너스 넘버는 당첨 넘버와 겹치치 않아야 합니다";
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumberNotOverlapWinningNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotOverlapWinningNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(NON_OVERLAPPING_NUMBER_REQUEST_MESSAGE);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}