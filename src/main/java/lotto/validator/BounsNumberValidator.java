package lotto.validator;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class BounsNumberValidator {
    private ErrorMessage errorMessage;
    private int maxValue, minValue;

    private int bonusNum;

    public BounsNumberValidator() {
        maxValue = LottoConstant.LOTTO_MAX_VALUE.getConstant();
        minValue = LottoConstant.LOTTO_MIN_VALUE.getConstant();
        bonusNum = 0;
    }

    public boolean validate(String num, List<Integer> prizeNums) {
        if (!validOtherString(num)) {
            return false;
        }
        if(!validNumLess1Over45(bonusNum)) {
            return false;
        }
        if(!validLottoNumOverLap(prizeNums)) {
            return false;
        }

        return true;
    }

    private boolean validOtherString(String buyAmount) {
        try {
            bonusNum = Integer.parseInt(buyAmount);
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_PRIZE_NUM_LESS_1_OVER_45;
            return false;
        }

        return true;
    }

    private boolean validNumLess1Over45(int num) {
        try {
            if(num < minValue || num > maxValue) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_PRIZE_NUM_LESS_1_OVER_45;
            return false;
        }

        return true;
    }

    private boolean validLottoNumOverLap(List<Integer> nums) {
        List<Integer> newNums = new ArrayList<>();
        newNums.addAll(nums);
        newNums.add(bonusNum);
        try {
            if(newNums.size() != newNums.stream().distinct().count()) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_BONUS_NUM_OVERLAP;
            return false;
        }
        return true;
    }

    public String getErrorMessage() {
        if(errorMessage != null)
            return errorMessage.getErrorMessage();
        return "";
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
