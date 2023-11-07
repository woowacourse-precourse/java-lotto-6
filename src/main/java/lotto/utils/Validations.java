package lotto.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.utils.Constants.*;

public class Validations {

    static String REGEX_NUMBER = "^(\\d)*$";
    static String REGEX_VALID_WINNING_NUMBERS = "^(\\d{1,2},){6}\\d{1,2}$";

    public static void checkWinningNumbersCount(String givenWinningNumbers) {
        Pattern pattern = Pattern.compile(REGEX_VALID_WINNING_NUMBERS);
        Matcher matcher = pattern.matcher(givenWinningNumbers);
        boolean matches = matcher.find();

        if(!matches) {
            throw new IllegalArgumentException(LottoMessages.WRONG_WINNING_NUMBERS.getKr());
        }
    }
    public static void checkDuplicateWinningNumbers(int[] givenWinningNumbers) {
        Set<Integer>set = new HashSet<>();
        for(int number: givenWinningNumbers) {
            set.add(number);
        }

        if(set.size() < LOTTO_DRAW_NUMBER_COUNT + LOTTO_DRAW_BONUS_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoMessages.DUPLICATE_NUMBER.getKr());
        }
    }

    public static void checkWinningNumberRange(int givenNumber) {
        if(givenNumber > LOTTO_UPPER_BOUND || givenNumber < LOTTO_UNDER_BOUND) {
            throw new IllegalArgumentException(LottoMessages.OUT_OF_LOTTO_NUMBER_BOUND.getKr());
        }
    }


    public static void checkNumber(String givenPrice) {
        Pattern pattern = Pattern.compile(REGEX_NUMBER);
        Matcher matcher = pattern.matcher(givenPrice);
        boolean matches = matcher.find();

        if(!matches) {
            System.out.println(LottoMessages.WRONG_NUMBER.getKr());
            throw new IllegalArgumentException(LottoMessages.WRONG_NUMBER.getKr());
        }
    }

    public static void checkDivideByLottoPrice(int givenPrice, int lottoPrice) {
        if(givenPrice == 0) {
            throw new IllegalArgumentException(LottoMessages.PRICE_ZERO.getKr());
        }

        if(givenPrice%lottoPrice != 0) {
            throw new IllegalArgumentException(LottoMessages.PRICE_DIVIDE_BY_LOTTO_PRICE.getKr());
        }
    }
}
