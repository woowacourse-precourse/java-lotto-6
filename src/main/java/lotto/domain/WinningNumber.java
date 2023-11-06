package lotto.domain;

import java.util.List;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_FORM;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_VALUE;

public class WinningLotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningNumber = new Lotto(numbers);

        //validateBonusNumber(winningNumber, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

//    private void validateBonusNumber(Lotto winningNumber, int bonusNumber){
//        validateBonusNumberDuplicate(winningNumber, bonusNumber);
//        validateBonusNumberRange(bonusNumber);
//    }
//
//    private void validateBonusNumberDuplicate(Lotto winningNumber, int bonusNumber){
//        if(winningNumber.isContainNumber(bonusNumber)){
//            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_VALUE.getMessage());
//        }
//    }
//
//    private void validateBonusNumberRange(int number){
//        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER ){
//            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORM.getMessage());
//        }
//    }

    public LottoRank calculateLottoRank(Lotto lotto){
        // same number cnt
        int count =0;

        return LottoRank.findLottoRank(count, isContainBonusNumber(lotto));
    }

    private boolean isContainBonusNumber(Lotto lotto){
        return lotto.isContainNumber(bonusNumber);
    }

}
