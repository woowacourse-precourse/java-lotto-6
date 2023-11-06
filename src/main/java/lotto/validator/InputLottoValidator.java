package lotto.validator;

import lotto.exception.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

public class InputLottoValidator {
    private static final String DELIMITER = ",";
    private static final Integer START_INDEX = 0;
    private static final Integer MAX_LOTTO_LENGTH = 6;
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;
    private InputLottoValidator() {
    }
    public static void validateEndsWithComma(final String input) {
        if (input.endsWith(DELIMITER)) {
            throw new InvalidLottoFormatException();
        }
    }
    public static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw new EmptyException();
        }
    }
    public static void validateLottoLength(final String input) {
        String[] validatedInput = input.split(DELIMITER);
        if(validatedInput.length != MAX_LOTTO_LENGTH){
            throw new InvalidLottoLengthException();
        }
    }
    public static void validateLottoIsNumeric(final String input) {
        try {
            Arrays.stream(input.split(DELIMITER), START_INDEX, MAX_LOTTO_LENGTH).forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new InvalidLottoFormatException();
        }
    }
    public static void validateLottoNumberRange(final String input){
        String[] validatedInput = input.split(DELIMITER);
        IntStream.range(0, MAX_LOTTO_LENGTH).filter(i -> Integer.parseInt(validatedInput[i]) < START_NUMBER || Integer.parseInt(validatedInput[i]) > END_NUMBER).forEach(i -> {
            throw new InvalidLottoNumberRangeException();
        });
    }
    public static void validateLottoNumberDuplicate(final String input){
        String[] validatedInput = input.split(DELIMITER);
        Set<String> set = Set.of(validatedInput);
        if(set.size() != MAX_LOTTO_LENGTH){
            throw new DuplicatedNumberException();
        }
    }
    public static void validateLotto(final String input) {
        validateEmpty(input);
        validateEndsWithComma(input);
        validateLottoLength(input);
        validateLottoIsNumeric(input);
        validateLottoNumberRange(input);
        validateLottoNumberDuplicate(input);
    }
}
