package lotto.utils;

import lotto.constant.StringConstant;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.NumberConstant.LOTTO_PRICE;
import static lotto.validator.GlobalValidator.validateNumber;
import static lotto.validator.WinningNumbersValidator.validateLottoNumberInRange;

public class LottoUtils {

    static final int PERCENT_CONVERSION_RATIO = 100;
    static final int ROUND_MULTIPLIER = 10;
    static final double ROUND_DIVISOR = 10.0;

    public static List<String> splitStringToList(StringConstant constant, String input) {
        String[] splitWithDelimiter = splitStringByDelimiter(constant, input);
        return Arrays.asList(splitWithDelimiter);
    }

    public static String[] splitStringByDelimiter(StringConstant constant, String input) {
        return input.split(constant.value());
    }

    public static int convertStringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static int validateAndConvertStringToInteger(String number) {
        validateNumber(number);
        int convertNumber = convertStringToInteger(number);
        validateLottoNumberInRange(convertNumber);
        return convertNumber;
    }

    public static double getEarningResult(int lottoCount, double totalPrize) {
        return (totalPrize / (lottoCount * LOTTO_PRICE.value())) * PERCENT_CONVERSION_RATIO;
    }

    public static double roundToFirstDecimal(double number) {
        return Math.round(number * ROUND_MULTIPLIER) / ROUND_DIVISOR;
    }

}
