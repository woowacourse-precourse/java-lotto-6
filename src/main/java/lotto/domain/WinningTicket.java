package lotto.domain;

public record WinningTicket(Lotto winningLotto, LottoNumber bonusNumber) {
    public static final String DUPLICATE_WINNING_NUMBER = "[ERROR] 당첨 번호와 보너스 번호에 중복된 숫자가 올 수 없습니다.";

    public WinningTicket {
        validate(winningLotto, bonusNumber);
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.has(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER);
        }
    }
}
