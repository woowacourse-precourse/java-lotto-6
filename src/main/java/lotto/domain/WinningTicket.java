package lotto.domain;

public record WinningTicket(Lotto winningLotto, LottoNumber bonusNumber) {

    public WinningTicket {
        validate(winningLotto, bonusNumber);
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.has(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
