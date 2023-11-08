package lotto.utils;

import lotto.global.error.ErrorMessage;
import lotto.view.InputValidator;

import java.util.List;

public class NumberHandler {

    public static List<Integer> numberMatches(List<Integer> firstNumbers, List<Integer> secondNumbers){
        return firstNumbers.stream()
                .distinct()
                .filter(secondNumbers::contains)
                .toList();
    }

    public static int parseLottoNumber(String lottoNumber){
        try{
            int parsedLottoNumber = Integer.parseInt(lottoNumber);
            InputValidator.isLottoInRange(parsedLottoNumber);
            return parsedLottoNumber;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
        }
    }

    public static int parseLottoPurchase(String lottoPurchase){
        try{
            int parsedLottoPurchase = Integer.parseInt(lottoPurchase);
            InputValidator.purchasePriceCheck(parsedLottoPurchase);
            return parsedLottoPurchase;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
        }
    }
}
