package lotto.domain;

public class WinningLotto {

    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String ERROR_WINNING_LOTTO_CONTAINS_BONUS_NUMBER = "우승 로또에 보너스 번호 포함 불가합니다";

    private Lotto lotto;
    public LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateLottoContainsBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Ranking calculateRanking(Lotto compareLotto) {
        long match = this.lotto.getLottoNumbers().stream()
            .filter(lottoNumber -> compareLotto.contains(lottoNumber))
            .count();

        boolean hasBonus = compareLotto.contains(this.bonusNumber);
        return Ranking.of(match, hasBonus);
    }

    private void validateLottoContainsBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                ERROR_MESSAGE_HEADER + ERROR_WINNING_LOTTO_CONTAINS_BONUS_NUMBER);
        }
    }
}
