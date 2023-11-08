package lotto.validator;

import static lotto.model.constants.IntegerConstant.*;
import static lotto.model.constants.RegexPattern.*;
import static lotto.validator.ExceptionMessage.*;
import static lotto.validator.ExceptionHandler.illegalArgument;


import java.util.List;
import java.util.regex.Pattern;
import lotto.model.lotto.WinningNumber;

public class Validator {
    private static final Pattern MULTIPLE_1000 = Pattern.compile(REGEX_MULTIPLE_1000.get());
    private static final Pattern NUMERIC = Pattern.compile(REGEX_NUMERIC.get());
    private static final Pattern NUMERIC_WITH_COMMA = Pattern.compile(REGEX_NUMERIC_WITH_COMMA.get());

    public static void numberMustBeMultipleOf1000(String input){
        if (MULTIPLE_1000.matcher(input).matches()) return;
        illegalArgument(PURCHASE_PRICE_MULTIPE_1000.getMessage());
    }

    public static void lottoMakesSixNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != SIZE_OF_LOTTO.get()) {
            illegalArgument(LOTTO_NUMBER_6_ONLY.getMessage());
        }
    }

    public static void lottoMustBeUniqueNumber(List<Integer> inputNumbers) {
        long inputNumberCount = inputNumbers.stream().distinct().count();
        if (inputNumbers.size() != inputNumberCount) {
            illegalArgument(LOTTO_NUMBER_UNIQUE.getMessage());
        }
    }

    public static void lottoMustBeUniqueNumber(WinningNumber winningNumber, Integer bonusNumber) {
        if (winningNumber.compareWinningNumberAndBonusNumber(bonusNumber)) {
            illegalArgument( BONUS_NUMBER_UNIQUE_WITH_WINNING_NUMBER.getMessage());
        }
    }

    public static void numberMustBe1To45(List<Integer> inputNumbers) {
        long count = inputNumbers.stream()
                .filter(Validator::isNumberValidRange)
                .count();
        if (count != inputNumbers.size()) {
            illegalArgument(LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean isNumberValidRange(int number){
        return (number >= MINIMUM_OF_LOTTO.get()) && (number <= MAXIMUM_OF_LOTTO.get());
    }

    public static void isInputEmpty(String input){
        if (input.isEmpty()){
            illegalArgument(INPUT_EMPTY.getMessage());
        }
    }

    public static void checkNumericInput(String input){
        if (NUMERIC.matcher(input).matches()) return;
        illegalArgument(INPUT_ONLY_NUMBER.getMessage());
    }

    public static void checkNumericWithCommaInput(String input){
        if (NUMERIC_WITH_COMMA.matcher(input).matches()) return;
        illegalArgument(INPUT_DIVIDE_ONLY_COMMA.getMessage());
    }
}
