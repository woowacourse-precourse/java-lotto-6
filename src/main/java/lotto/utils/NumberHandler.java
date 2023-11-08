package lotto.utils;

import lotto.global.ResponseStatus;
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
        InputValidator.isInputDigit(lottoNumber);
        int parsedLottoNumber = Integer.parseInt(lottoNumber);
        InputValidator.isLottoInRange(parsedLottoNumber);
        return parsedLottoNumber;
    }

    public static int parseLottoPurchase(String lottoPurchase){
        InputValidator.isInputDigit(lottoPurchase);
        int parsedLottoPurchase = Integer.parseInt(lottoPurchase);
        InputValidator.purchasePriceCheck(parsedLottoPurchase);
        return parsedLottoPurchase;
    }
}
