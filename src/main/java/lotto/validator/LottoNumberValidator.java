package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessages;

public class LottoNumberValidator {
    public static void validate(String lottoNumberInput) {
        isNumeric(lottoNumberInput);
        isCountSix(lottoNumberInput);

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
