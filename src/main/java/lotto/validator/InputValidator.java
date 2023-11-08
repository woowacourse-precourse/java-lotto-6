package lotto.validator;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstant;

import java.util.ArrayList;

public class InputValidator {

    private ErrorMessage errorMessage;
    private int lottoPrice, maxValue, minValue, lottoSize;

    private int resultAmount;
    private ArrayList<Integer> lottoNums;

    public InputValidator() {
        lottoPrice = LottoConstant.LOTTO_PRICE.getConstant();
        maxValue = LottoConstant.LOTTO_MAX_VALUE.getConstant();
        minValue = LottoConstant.LOTTO_MIN_VALUE.getConstant();
        lottoSize = LottoConstant.LOTTO_SIZE.getConstant();
        resultAmount = 0;
        lottoNums = new ArrayList<>();
    }

    public boolean validLottoBuyAmount(String buyAmount) {

        if (!validAmountOtherString(buyAmount)) {
            return false;
        }
        if(!validAmountLess1000(resultAmount)) {
            return false;
        }
        if(!validAmountUndivided1000(resultAmount)) {
            return false;
        }

        return true;
    }

    public boolean validAmountOtherString(String buyAmount) {
        try {
            resultAmount = Integer.parseInt(buyAmount);
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_AMOUNT_OTHER_STRING;
            return false;
        }

        return true;
    }

    public boolean validAmountLess1000(int num) {
        try {
            if(num < lottoPrice) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_AMOUNT_LESS_1000;
            return false;
        }

        return true;
    }

    public boolean validAmountUndivided1000(int num) {
        try {
            if(num % lottoPrice != 0) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_AMOUNT_UNDIVIDED_1000;
            return false;
        }

        return true;
    }

    public boolean validLottoPrizeNums(String prizeNum) {

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
            errorMessage = ErrorMessage.ERROR_AMOUNT_OTHER_STRING;
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
            if(nums.size() > lottoSize || nums.isEmpty()) {
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

    public int getResultAmount() {
        return resultAmount / lottoPrice;
    }

    public ArrayList<Integer> getLottoNums() {
        return lottoNums;
    }
}
