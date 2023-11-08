package lotto.validator;

import static lotto.constant.Constants.LOTTO_NUMBER_COUNT;
import static lotto.constant.Constants.MAX_LOTTO_NUMBER;
import static lotto.constant.Constants.MIN_LOTTO_NUMBER;

import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessages;

public class LottoNumberValidator {
    public static void validate(String lottoNumberInput) {
        isNumeric(lottoNumberInput);
        isCountSix(lottoNumberInput);
        isInRange(lottoNumberInput);
        isUnique(lottoNumberInput);
    }

    private static void isUnique(String lottoNumberInput) {
        try {
            Set<String> checkDuplicateNumber = Set.of(lottoNumberInput.split(","));
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessages.NOT_UNIQUE.getMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_UNIQUE.getMessage());
        }
    }

    private static void isInRange(String lottoNumberInput) {
        List<String> lottoNumbers = List.of(lottoNumberInput.split(","));
        for (String lottoNumber : lottoNumbers) {
            if (Integer.parseInt(lottoNumber) < MIN_LOTTO_NUMBER || Integer.parseInt(lottoNumber) > MAX_LOTTO_NUMBER) {
                System.out.println(ErrorMessages.NOT_IN_RANGE.getMessage());
                throw new IllegalArgumentException(ErrorMessages.NOT_IN_RANGE.getMessage());
            }
        }
    }

    private static void isCountSix(String lottoNumberInput) {
        if (lottoNumberInput.split(",").length != LOTTO_NUMBER_COUNT) {
            System.out.println(ErrorMessages.NOT_SIX.getMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_SIX.getMessage());
        }
    }

    private static void isNumeric(String lottoNumberInput) {
        List<String> lottoNumbers = List.of(lottoNumberInput.split(","));
        for (String lottoNumber : lottoNumbers) {
            try {
                Integer.parseInt(lottoNumber);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.NOT_LOTTO_NUMBER.getMessage());
                throw new NumberFormatException(ErrorMessages.NOT_LOTTO_NUMBER.getMessage());
            }
        }
    }


}
