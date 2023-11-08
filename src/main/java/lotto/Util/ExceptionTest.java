package lotto.Util;

import lotto.Constant.LottoNumber;

import java.util.Arrays;
import java.util.regex.Pattern;

import static lotto.Constant.Const.*;
import static lotto.Constant.LottoNumber.*;


public class ExceptionTest extends Throwable {

    public int checkUserInputPrice(String userInputPrice){
        checkUserInputPriceIsNumber(userInputPrice);
        return checkUserInputPriceIsMuiltiple(userInputPrice);
    }
    public int checkUserInputPriceIsNumber(String userInputPrice){
        // 사용자가 입력한 가격이 숫자가 아닐 때.
        String checkNumber = "[0-9]+";

        if (!Pattern.matches(checkNumber, userInputPrice)){
            throw new IllegalArgumentException(EXCEPTION_ERROR);
        }
        return checkUserInputPriceIsMuiltiple(userInputPrice);
    }

    public int checkUserInputPriceIsMuiltiple(String userInputPrice){
        // 사용자가 입력한 숫자가 1000의 배수가 아닐 때
        int userPrice = Integer.parseInt(userInputPrice);
        if (userPrice % LottoNumber.PURCHASE_LOTTO_PRICE.getLottoNumber() != 0){
            throw new IllegalArgumentException(EXCEPTION_ERROR_NOT_AVAILABLE);
        }
        return userPrice;
    }

    public void checkWinningCount(String[] inputNums) {
        if (inputNums.length != NUMBER_COUNT.getLottoNumber()) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_ERROR);
        }
    }

    public void checkDuplicate(String[] inputNums) {
        if (Arrays.stream(inputNums).distinct().count() != NUMBER_COUNT.getLottoNumber()) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_MULTIPLE_ERROR);
        }
    }

}
