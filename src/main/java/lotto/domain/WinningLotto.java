package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_VALUE;

public class WinningLotto {

    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        validateBonusNumber(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningNumber, int bonusNumber){
        if(winningNumber.isContainNumber(bonusNumber)){
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_VALUE.getMessage());
        }
    }


    //TODO: 로또 1개에 대해 일치 개수 계산


}
