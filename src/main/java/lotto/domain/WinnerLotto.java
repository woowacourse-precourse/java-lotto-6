package lotto.domain;

public class WinnerLotto {
    private Lotto winnerLotto;
    private int bonusNumber;

    private WinnerLotto(final Lotto winnerLotto, final int bonusNumber) {
        validateDuplicationBonusNumber(winnerLotto, bonusNumber);
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerLotto of(final Lotto winnerLotto, final int bonusNumber) {
        return new WinnerLotto(winnerLotto, bonusNumber);
    }

    public static void validateDuplicationBonusNumber(Lotto lotto, int matchNumber) {
        if(lotto.getLotto()
                .stream()
                .anyMatch(lottoNumber -> lottoNumber == matchNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }
}
