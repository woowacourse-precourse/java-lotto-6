package lotto.domain;

import lotto.util.ExceptionMessageGenerator;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;
    private static final String OVERLAPPING_WITH_WINNING_NUMBERS = "보너스번호는 당첨번호와 중복되지 않아야 합니다.";

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, LottoNumber bonusNumber) {
        ExceptionMessageGenerator exceptionMessageGenerator = ExceptionMessageGenerator.INSTANCE;

        if (winningNumbers.isContains(bonusNumber)) {
            throw new IllegalArgumentException(exceptionMessageGenerator.makeMessage(OVERLAPPING_WITH_WINNING_NUMBERS));
        }
    }

    public Rank getRank(Lotto lotto) {
        long matchCount = winningNumbers.getMatchCount(lotto);
        boolean isMatchBonusNumber = lotto.isContains(bonusNumber);
        return Rank.getRank((int) matchCount, isMatchBonusNumber);
    }
}
