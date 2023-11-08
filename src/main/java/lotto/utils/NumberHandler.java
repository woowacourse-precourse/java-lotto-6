package lotto.utils;

import lotto.global.error.ErrorMessage;

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
            return Integer.parseInt(lottoNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
        }
    }
}
