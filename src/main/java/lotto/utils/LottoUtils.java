package lotto.utils;

import lotto.constant.StringConstant;

import java.util.Arrays;
import java.util.List;

import static lotto.validator.GlobalValidator.validateNumber;
import static lotto.validator.WinningNumbersValidator.validateLottoNumberInRange;

public class LottoUtils {

    public static List<String> splitStringToList(StringConstant constant, String input) {
        String[] splitWithDelimiter = splitStringByDelimiter(constant, input);
        return Arrays.asList(splitWithDelimiter);
    }

    public static String[] splitStringByDelimiter(StringConstant constant, String input) {
        return input.split(constant.value());
    }

    public static int convertStringToInteger(String input){
        return Integer.parseInt(input);
    }

    public static int validateAndConvertStringToInteger(String number) {
        validateNumber(number);
        int convertNumber = convertStringToInteger(number);
        validateLottoNumberInRange(convertNumber);
        return convertNumber;
    }

}
