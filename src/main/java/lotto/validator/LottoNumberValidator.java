package lotto.validator;

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
        List<String> lottoNumbers = List.of(lottoNumberInput.split(","));
        Set<String> uniqueLottoNumbers = Set.of(lottoNumberInput.split(","));
        if (lottoNumbers.size() != uniqueLottoNumbers.size()) {
            System.out.println(ErrorMessages.NOT_UNIQUE.getMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_UNIQUE.getMessage());
        }
    }

    private static void isInRange(String lottoNumberInput) {
        List<String> lottoNumbers = List.of(lottoNumberInput.split(","));
        for (String lottoNumber : lottoNumbers) {
            if (Integer.parseInt(lottoNumber) < 1 || Integer.parseInt(lottoNumber) > 45) {
                System.out.println(ErrorMessages.NOT_IN_RANGE.getMessage());
                throw new IllegalArgumentException(ErrorMessages.NOT_IN_RANGE.getMessage());
            }
        }
    }

    private static void isCountSix(String lottoNumberInput) {
        if (lottoNumberInput.split(",").length != 6) {
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
