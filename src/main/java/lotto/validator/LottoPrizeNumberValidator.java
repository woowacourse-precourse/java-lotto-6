package lotto.validator;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstant;

import java.util.ArrayList;

public class LottoPrizeNumberValidator {

    private ErrorMessage errorMessage;
    private int maxValue, minValue, lottoSize;

    private ArrayList<Integer> lottoNums;

    public LottoPrizeNumberValidator() {
        maxValue = LottoConstant.LOTTO_MAX_VALUE.getConstant();
        minValue = LottoConstant.LOTTO_MIN_VALUE.getConstant();
        lottoSize = LottoConstant.LOTTO_SIZE.getConstant();
        lottoNums = new ArrayList<>();
    }

    public boolean validate(String prizeNum) {

       if(!validPrizeNumOtherString(prizeNum)) {
           return false;
       }
       if(!validLottoNumLess1Over45(lottoNums)) {
           return false;
       }
        if(!validOverLottoSize(lottoNums)) {
            return false;
        }
        if(!validLottoNumOverLap(lottoNums)) {
            return false;
        }

        return true;
    }

    public boolean validPrizeNumOtherString(String prizeNum) {
        lottoNums.clear();

        try {
            String [] prizeNums = prizeNum.split(",", -1);
            for(int i=0;i<prizeNums.length;i++) {
                lottoNums.add(Integer.parseInt(prizeNums[i]));
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_PRIZE_NUM_OVERLAP;
            return false;
        }
        return true;
    }

    public boolean validLottoNumLess1Over45(ArrayList<Integer> nums) {
        try {
            if(!nums.stream().allMatch(num -> (num >= minValue && num <= maxValue))) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_PRIZE_NUM_LESS_1_OVER_45;
            return false;
        }

        return true;
    }

    public boolean validOverLottoSize(ArrayList<Integer> nums) {
        try {
            if(nums.size() != lottoSize) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_PRIZE_NUM_SIZE_LESS_OR_OVER_6;
            return false;
        }

        return true;
    }

    public boolean validLottoNumOverLap(ArrayList<Integer> nums) {
        try {
            if(nums.size() != nums.stream().distinct().count()) {
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

    public ArrayList<Integer> getLottoNums() {
        return lottoNums;
    }
}
