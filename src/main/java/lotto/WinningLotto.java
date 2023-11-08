package lotto;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningLotto, Integer bonusNumber) {
        LottoValidator.sizeValidate(winningLotto);
        LottoValidator.rangeValidateFromList(winningLotto);
        LottoValidator.rangeValidate(bonusNumber);
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");
        }
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
