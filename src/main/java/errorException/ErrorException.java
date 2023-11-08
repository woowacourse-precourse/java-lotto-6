package errorException;

import value.ErrorMessage;
import input.ConvertInput;

public class ErrorException {

    public static boolean checkMoneyNumber(String string) {
        boolean result = true;
        if (!checkMoneyNon(string)) {
            result = false;
            throw new IllegalArgumentException(ErrorMessage.PAY_MONEY.getString());
        }

        if (!checkMoneyRemains(string)) {
            result = false;
            throw new IllegalArgumentException(ErrorMessage.PAY_PROPER_MONEY_AMOUNT.getString());
        }

        if (!checkMoneyInNumber(string)) {
            result = false;
            throw new IllegalArgumentException(ErrorMessage.PAY_MONEY_IN_NUMBER.getString());
        }

        return true;
    }

//    public static boolean checkLottoNumber(String string){
//    // lotto number가 수가 아닌 값이거나 범위를 벗어난 값인 경우
//        if(!checkNumberRange(numbers)){
//            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getString());
//            return false;
//        }
//        if()
//    }
//
//    public static boolean checkBonusNumber(String string){
//
//    }

    //-------------------------------------------------------------------------
    static boolean checkMoneyNon(String string) {
        return string.length() != 0;
    }

    static boolean checkMoneyRemains(String string) {
        return ConvertInput.numInput(string) % 1000 == 0;
    }

    static boolean checkMoneyInNumber(String string) {
        char[] arr = ConvertInput.str2CharArr(string);
        for (char c : arr) {
            int digit = c - '0';
            if (digit >= 10) {
                return false;
            }
        }
        return true;
    }

//    static boolean checkNumberRange(List<Integer> numbers){
//        if()
//    }
}
