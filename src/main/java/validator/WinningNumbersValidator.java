package validator;

import util.constants.LottosConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static util.message.ExceptionMessage.*;

public class WinningNumbersValidator extends Validator{

    private static final String COMMA = ",";
    public static List<Integer> validate(String input) {
        validateBlank(input);
        return validateNumbers(input);
    }

    private static List<Integer> validateNumbers(String input){
        String[] inputs = input.split(COMMA);
        validateSize(inputs);
        List<Integer> numbers = validateNumeric(inputs);
        validateRange(LottosConstants.MIN_VALUE.getValue(), LottosConstants.MAX_VALUE.getValue(), numbers);
        return numbers;
    }

    private static void validateSize(String[] inputs){
        if(inputs.length != LottosConstants.LOTTO_SIZE.getValue()){
            throw new IllegalArgumentException(BLANK_MESSAGE.getValue());
        }
    }

    private static List<Integer> validateNumeric(String[] inputs){
        List<Integer> numbers = new ArrayList<>();
        for(String number : inputs){
            if(!isNumeric(number.trim())){
                throw new IllegalArgumentException(BLANK_MESSAGE.getValue());
            }
            numbers.add(changeStringToInt(number));
        }
        return numbers;
    }

    private static int changeStringToInt(String number){
        return Integer.parseInt(number);
    }

    private static boolean isNumeric(String str){
        return Pattern.matches("\\d+", str);
    }

    protected static void validateRange(final int start, final int end, final List<Integer> numbers) {
        for(int number : numbers){
            if (number >= start && number <= end) {
                throw new IllegalArgumentException(String.format(RANGE_START_BETWEEND_END.getValue(), start, end));
            }
        }
    }
}
