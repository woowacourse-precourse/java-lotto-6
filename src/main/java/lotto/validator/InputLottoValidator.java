package lotto.validator;

import lotto.exception.LottoException;
import lotto.exception.constant.ErrorMessage;

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
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_FORMAT);
        }
    }
    public static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw LottoException.of(ErrorMessage.EMPTY);
        }
    }
    public static void validateLottoLength(final String input) {
        String[] validatedInput = input.split(DELIMITER);
        if(validatedInput.length != MAX_LOTTO_LENGTH){
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_LENGTH);
        }
    }
    public static void validateLottoIsNumeric(final String input) {
        try {
            Arrays.stream(input.split(DELIMITER), START_INDEX, MAX_LOTTO_LENGTH).forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_FORMAT);
        }
    }
    public static void validateLottoNumberRange(final String input){
        String[] validatedInput = input.split(DELIMITER);
        IntStream.range(0, MAX_LOTTO_LENGTH).filter(i -> Integer.parseInt(validatedInput[i]) < START_NUMBER || Integer.parseInt(validatedInput[i]) > END_NUMBER).forEach(i -> {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        });
    }
    public static void validateLottoNumberDuplicate(final String input){
        String[] validatedInput = input.split(DELIMITER);
        Set<String> set = Set.of(validatedInput);
        if(set.size() != MAX_LOTTO_LENGTH){
            throw LottoException.of(ErrorMessage.DUPLICATED_NUMBER);
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
