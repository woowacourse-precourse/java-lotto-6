package lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private static final String MATCH_NUMBER_EXCEPTION_MESSAGE = "당첨 번호 중 보너스 번호와 일치하는 숫자가 존재합니다.";

    private final Lotto lotto;
    private final BonusNumber bonusNumbers;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateWinningLotto(lotto, bonusNumber);

        this.lotto = lotto;
        this.bonusNumbers = bonusNumber;
    }

    private void validateWinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(MATCH_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public LottoRanking compare(Lotto userLotto) {
        int numberOfMatches = lotto.countNumberOfMatches(userLotto);
        boolean hasBonusNumber = userLotto.hasBonusNumber(bonusNumbers);

        return LottoRanking.of(numberOfMatches, hasBonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumbers, that.bonusNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumbers);
    }
}
