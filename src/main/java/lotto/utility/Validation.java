package lotto.utility;

import lotto.utility.enums.ExceptionMessages;
import lotto.utility.enums.RegularExpressionPatterns;
import lotto.utility.enums.Standards;

import java.lang.reflect.Parameter;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validation {
    private static final String COMMA = ",";
    private static final String EMPTY = "";

    public static void vaildatePurchaseAmount(String purchaseAmount) {
        isEmpty(purchaseAmount);
        isNumber(purchaseAmount);
        isDivisibleByThousand(purchaseAmount);
    }

    public static void vaildateWinningNumbers(String winningNumbers) {
        //입력된 문자열의 구성이 올바른지 판단
        isEmpty(winningNumbers);
        isNotNumbersOrComma(winningNumbers);
        isCommaAtImproperPosition(winningNumbers);
        isCommaCountFive(winningNumbers);

        //입력된 숫자의 속성이 올바른지 판단
        isDuplicateNumbers(winningNumbers);
        isNumbersRangeOneToFortyFive(winningNumbers);
    }

    //사용자 구입 금액 예외처리
    private static void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalStateException(ExceptionMessages.IS_EMPTY.getMessage());
        }
    }

    private static void isNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionMessages.NOT_NUMBER_MESSAGE.getMessage());
        }
    }

    private static void isDivisibleByThousand(String purchaseAmount) {
        if (!(Integer.parseInt(purchaseAmount) % Standards.ONE_LOTTO_COST.getNumber() == Standards.ZERO.getNumber())) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }

    //당첨금액 입력 예외처리
    private static void isNotNumbersOrComma(String winningNumbers) {
        String WinningNumbersWithoutComma = winningNumbers.replaceAll(COMMA, EMPTY); //문자열에서 컴마 제거

        if(!Pattern.matches(RegularExpressionPatterns.VALID_ONLY_NUMBERS.getPattern(),WinningNumbersWithoutComma)){
            throw new IllegalArgumentException(ExceptionMessages.NOT_NUMBERS_AND_COMMA.getMessage());
        }
    }

    private static void isCommaAtImproperPosition(String winningNumbers) {
        if (Pattern.matches(RegularExpressionPatterns.VALID_IMPROPER_COMMA_POSITION_PATTERN.getPattern(), winningNumbers)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_PROPER_COMMA_POSITION.getMessage());
        }
    }

    private static void isCommaCountFive(String winningNumbers) { //컴마의 개수가 5개인지 파악
        if (!(winningNumbers.length() - winningNumbers.replaceAll(COMMA, EMPTY).length() == Standards.CORRECT_COMMA_COUNT.getNumber())) {
            throw new IllegalArgumentException(ExceptionMessages.INCORRECT_NUMBER_COUNT.getMessage());
        }
    }

    private static void isDuplicateNumbers(String winningNumbers) {
        List<String> numbers = castTypeStringToStringListByComma(winningNumbers);

        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessages.IS_DUPLICATE_NUMBERS.getMessage());
        }
    }

    private static void isNumbersRangeOneToFortyFive(String winningNumbers) {
        List<Integer> numbers = castTypeStringListToIntegerList(castTypeStringToStringListByComma(winningNumbers));

        for(int number : numbers){
            if( number < Standards.MIN_LOTTO_NUMBER.getNumber() || number > Standards.MAX_LOTTO_NUMBER.getNumber()){
                throw new IllegalArgumentException(ExceptionMessages.OUT_OF_NUMBER_RANGE.getMessage());
            }
        }
    }

    private static List<String> castTypeStringToStringListByComma(String input) {
        List<String> result = List.of(input.split(COMMA));

        return result;
    }

    private static List<Integer> castTypeStringListToIntegerList(List<String> input){
        List<Integer> result =  input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return result;
    }
}
