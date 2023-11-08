package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ErrorMessage;

public class Validator {
    public static void validateMoney(String MoneyInput){
        int money = convertToNumber(MoneyInput);
        isNotLack(money);
        isDivBy1000(money);
    }

    private static int convertToNumber(String str) {
        try {
            int num = Integer.parseInt(str);
            return num;
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INT.getMessage());
        }
    }
    private static void isNotLack(int num){
        if(num<1000){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_POSITIVE.getMessage());
        }
    }
    private static void isDivBy1000(int num){
        if(num%1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_MONEY_DIV.getMessage());
        }
    }


    public static void validateWinnigNumber( List<String> winningNumber){
        isStrListDuplicate(winningNumber);
        isValidSize(winningNumber);
        winningNumber.forEach((e)->{
            int num = convertToNumber(e);
            isValidRange(num);
        });
    }

    public static void isValidRange(int num){
        if (num<1 || num>45){
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_RANGE.getMessage());
        }
    }
    private static void isValidSize(List<String> list){
        if (list.size()!=6){
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_SIZE.getMessage());
        }
    }
    private static void isStrListDuplicate(List<String> list){
        Set<String> set = new HashSet<String>(list);
        if (list.size()!=set.size()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_DUPLICATE.getMessage());
        }
    }


    public static void isIntListDuplicate(List<Integer> list){
        Set<Integer> set = new HashSet<Integer>(list);
        if (list.size()!=set.size()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_DUPLICATE.getMessage());
        }
    }

    public static void validateBonusNumber(String bonusNumberInput, List<Integer> winningNumber){
        int bonusNumber = convertToNumber(bonusNumberInput);
        isValidRange(bonusNumber);
        isBonusDuplicate(bonusNumber, winningNumber);

    }

    private static void isBonusDuplicate(int bonusNumber, List<Integer> winningNumber){
        if (winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_DUPLICATE.getMessage());

        }
    }
    }
