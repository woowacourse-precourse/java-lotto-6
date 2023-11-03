package lotto.model;

public class WinningTicket {
    private static final String BONUS_NUMBER_DUPLICATION_EXCEPTION = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningTicket(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    public static WinningTicket of(Lotto winningLotto, LottoNumber bonusNumber) {
        return new WinningTicket(winningLotto, bonusNumber);
    }

    public boolean containsLottoNumber(LottoNumber number) {
        return winningLotto.contains(number);
    }

    public boolean containsBonusNumber(LottoNumber number) {
        return bonusNumber.equals(number);
    }
}
