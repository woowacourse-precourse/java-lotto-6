package lotto.domain;

import static lotto.message.ExceptionMessage.INPUT_NOT_DISTINCT;

public class WinningLotto {

    private Lotto winningLotto;
    private Integer bonusNumber;

    public WinningLotto(Lotto winningLotto, Integer bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, Integer bonusNumber){
        validateNumbersDuplicate(winningLotto, bonusNumber);
    }

    private void validateNumbersDuplicate(Lotto winningLotto, Integer bonusNumber) {
        if (winningLotto.contains(bonusNumber)){
            throw new IllegalArgumentException(INPUT_NOT_DISTINCT);
        }
    }

    public int compareLotto(Lotto lotto){
        return winningLotto.compare(lotto);
    }

    public boolean compareBonusNumber(Lotto lotto){
        return lotto.contains(bonusNumber);
    }
}
