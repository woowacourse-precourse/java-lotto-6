package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.constant.ErrorOutputMessage;
import lotto.constant.LottoNumber;

public class ValidationUtil {
    
    public static int validatePurchase(String userMoney) {
        validateNumberType(userMoney);
        return validateRemainder(userMoney);
    }

    private static void validateNumberType(String userMoney) {
        String regex = "[0-9]+";

        if (!Pattern.matches(regex, userMoney)) {
            throw new IllegalArgumentException(ErrorOutputMessage.PURCHASE_TYPE);
        }
    }

    private static int validateRemainder(String userPurchase) {
        int userMoney = Integer.parseInt(userPurchase);

        if (userMoney % LottoNumber.PURCHASE__PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorOutputMessage.PURCHASE_REMAINDER);
        }
        
        return userMoney;
    }

    public static String[] validateLottoNumber(String[] lottoNumber) {
        validateDuplicate(lottoNumber);
        validateLottoNumberCount(lottoNumber);
        validateBlank(lottoNumber);
        validateRange(lottoNumber);
        return lottoNumber;
    }

    private static void validateLottoNumberCount(String[] lottoNumber) {
        if (lottoNumber.length != LottoNumber.LOTTO__SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorOutputMessage.NUMBER_COUNT);
        }
    }

    private static void validateBlank(String[] lottoNumber) {
        for (String number : lottoNumber) {
            if (number.contains(" ") || number.equals("")) {
                throw new IllegalArgumentException(ErrorOutputMessage.NUMBER_BLANK);
            }
        }
    }

    private static void validateDuplicate(String[] lottoNumber) {
       if (Arrays.stream(lottoNumber).distinct().count() != LottoNumber.LOTTO__SIZE.getNumber()) {
           throw new IllegalArgumentException(ErrorOutputMessage.NUMBER_DUPLICATE);
       }
    }

    private static void validateRange(String[] lottoNumber) {
        for (String number : lottoNumber) {
            if (Integer.parseInt(number) < LottoNumber.FIRST__RANGE.getNumber() || Integer.parseInt(number) > LottoNumber.LAST__RANGE.getNumber()) {
                throw new IllegalArgumentException(ErrorOutputMessage.NUMBER_RANGE);
            }
        }
    }

    public static int validateBonusNumber(String bonusNumber, List<Integer> winningNumber) {
        validateBonusNumberDuplicate(bonusNumber, winningNumber);
        validateBonusNumberBlank(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validateBonusNumberDuplicate(String bonusNumber, List<Integer> winningNumber) {
        if (Arrays.asList(null, winningNumber).contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorOutputMessage.BONUS_NUMBER_DUPLICATE);
        }
    }
    
    private static void validateBonusNumberBlank(String bonusNumber) {
        if (bonusNumber.contains(" ") || bonusNumber.equals("")) {
            throw new IllegalArgumentException(ErrorOutputMessage.BONUS_NUMBER_BLANK);
        }
    }

    private static void validateBonusNumberRange(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < LottoNumber.FIRST__RANGE.getNumber() || Integer.parseInt(bonusNumber) > LottoNumber.LAST__RANGE.getNumber()) {
            throw new IllegalArgumentException(ErrorOutputMessage.NUMBER_RANGE);
        }
    }
}