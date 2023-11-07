package lotto.exception;

import lotto.constant.ExceptionConstants;
import lotto.constant.GameConstants;

import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class LottoNumberException {
    public static void validateFormat(String lotto) {
        if (!lotto.matches("^\\d+,\\d+,\\d+,\\d+,\\d+,\\d+$")) {
            throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_INVALID_NUMBER_FORMAT, GameConstants.LOTTO_SIZE));
        }
    }

    //int max범위를 넘어갈 때
    public static void validateNumbersInRangeMaxInt(String lotto){
        StringTokenizer numbers = new StringTokenizer(lotto, ",");
        while(numbers.hasMoreTokens()){
            try{
                Integer.parseInt(numbers.nextToken());
            }catch(NumberFormatException e){
                throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_INPUT_NOT_LESS_THAN_LOTTO_PRICE, GameConstants.MAX_PURCHASE_PRICE));
            }
        }
    }
    public static void validateNumbersInRange(List<Integer> lotto){
        for(Integer number : lotto){
            if(number < GameConstants.STARTINCLUSIVE){
                throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_NUMBER_OUT_OF_MIN_RANGE, GameConstants.STARTINCLUSIVE));
            }
            if(number > GameConstants.ENDINCLUSIVE){
                throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_NUMBER_OUT_OF_MAX_RANGE, GameConstants.ENDINCLUSIVE));
            }
        }
    }
    public static void validateNoDuplicates(List<Integer> lotto){
        int distinctCount = lotto.stream().distinct().collect(Collectors.toList()).size();
        if(distinctCount < GameConstants.LOTTO_SIZE){
            throw new IllegalArgumentException(ExceptionConstants.ERROR_DUPLICATE_NUMBER);
        }
    }


    //보너스 번호
    public static void validateBonusNumberFormat(String bonusNumber) {
        if (!bonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_NON_NUMERIC_INPUT, GameConstants.LOTTO_SIZE));
        }
    }
    //int max범위보다 벗어났을때
    public static void validateBonusNumbersInRangeMaxInt(String bonusNumber){
        try{
            Integer.parseInt(bonusNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_NUMBER_OUT_OF_MAX_RANGE, GameConstants.ENDINCLUSIVE));
        }
    }
    public static void validateNumbersInRange(int bonusNumber){
        if(bonusNumber < GameConstants.STARTINCLUSIVE){
            throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_NUMBER_OUT_OF_MIN_RANGE, GameConstants.STARTINCLUSIVE));
        }
        if(bonusNumber > GameConstants.ENDINCLUSIVE){
            throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_NUMBER_OUT_OF_MAX_RANGE, GameConstants.ENDINCLUSIVE));
        }
    }

    public static void validateBonusNumberWithLotto(int bonusNumber, List<Integer> lotto){
        if(lotto.contains(bonusNumber)){
            throw new IllegalArgumentException(ExceptionConstants.ERROR_DUPLICATE_LOTTO_AND_BONUS_NUMBER);
        }

    }


}
