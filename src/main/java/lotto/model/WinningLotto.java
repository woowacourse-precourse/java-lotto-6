package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("당첨 번호화 중복된 번호는 입력할 수 없습니다.");
        }
    }

    public int getMatchCount(Lotto lottoTicket) {
        return (int) winningLotto.getNumbers().stream()
                .filter(lottoTicket.getNumbers()::contains)
                .count();
    }

    public boolean hasBonusNumber(Lotto lottoTicket) {
        return lottoTicket.getNumbers()
                .contains(bonusNumber.getBonusNumber());
    }
}