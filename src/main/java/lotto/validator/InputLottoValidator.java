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
    public InputLottoValidator() {
    }
    public static void validateStartsWithComma(final String lottoNumbers) {
        if (lottoNumbers.startsWith(DELIMITER)) {
            throw new InvalidLottoFormatException();
        }
    }
    public static void validateEndsWithComma(final String lottoNumbers) {
        if (lottoNumbers.endsWith(DELIMITER)) {
            throw new InvalidLottoFormatException();
        }
    }

    public static void validateEmpty(final String lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw new EmptyException();
        }
    }

    public static void validateLottoLength(final String lottoNumbers) {
        String[] validatedInput = lottoNumbers.split(DELIMITER);
        if(validatedInput.length != MAX_LOTTO_LENGTH){
            throw new InvalidLottoLengthException();
        }
    }

    public static void validateLottoIsNumeric(final String lottoNumbers) {
        try {
            Arrays.stream(lottoNumbers.split(DELIMITER), START_INDEX, MAX_LOTTO_LENGTH).forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new InvalidLottoFormatException();
        }
    }

    public static void validateLottoNumberRange(final String lottoNumbers){
        String[] validatedInput = lottoNumbers.split(DELIMITER);
        IntStream.range(START_INDEX, MAX_LOTTO_LENGTH)
                .filter(i -> Integer.parseInt(validatedInput[i]) < START_NUMBER || Integer.parseInt(validatedInput[i]) > END_NUMBER)
                .forEach(i -> {
                    throw new InvalidLottoNumberRangeException();
                });
    }

    private static void validateLottoNumberDuplicate(final String lottoNumbers){
        String[] validatedInput = lottoNumbers.split(DELIMITER);
        Set<String> set = Set.of(validatedInput);
        if(set.size() != MAX_LOTTO_LENGTH){
            throw new DuplicatedNumberException();
        }
    }

    public static void validateLotto(final String lottoNumbers) {
        validateEmpty(lottoNumbers);
        validateStartsWithComma(lottoNumbers);
        validateEndsWithComma(lottoNumbers);
        validateLottoLength(lottoNumbers);
        validateLottoIsNumeric(lottoNumbers);
        validateLottoNumberRange(lottoNumbers);
        validateLottoNumberDuplicate(lottoNumbers);
    }
}
