package lotto.controller;

import static lotto.message.ExceptionMessage.*;

import java.util.List;
import lotto.Util;
import lotto.message.ExceptionMessage;

public class Validation {

    public void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER.getMessage());
        }
    }

    public void isNumber(List<String> input) {
        try {
            for(String num : input) {
                Integer.parseInt(num);
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER.getMessage());
        }
    }

    public void lottoNumberCount(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE.getMessage());
        }
    }

    public void duplicateNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE.getMessage());
        }
    }

    public void rangeOfLottoNumber(int num) {
       if (num < 1 || num > 45) {
                throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    public void rangeOfLottoNumber(List<Integer> numbers) {
        for(int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
            }
        }
    }

    public void purchaseAmount(String input) {
        isNumber(input);
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT.getMessage());
        }
    }

    public void winNumber(List<String> numbers) {
        Util util = new Util();
        List<Integer> winNumber = util.stringListToIntegerList(numbers);
        lottoNumberCount(winNumber);
        duplicateNumber(winNumber);
        rangeOfLottoNumber(winNumber);
    }

    public void bonusNumber(String input, List<Integer> winNumber) {
        isNumber(input);
        int number = Integer.parseInt(input);
        rangeOfLottoNumber(number);
        if(winNumber.contains(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER.getMessage());
        }
    }
}
