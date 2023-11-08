package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessages;

public class LottoNumberValidator {
    public static void validate(String lottoNumberInput) {
        isNumeric(lottoNumberInput);

    }

    private static void isNumeric(String lottoNumberInput) {
        List<String> lottoNumbers = List.of(lottoNumberInput.split(","));
        for (String lottoNumber : lottoNumbers) {
            try {
                Integer.parseInt(lottoNumber);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(ErrorMessages.NOT_LOTTO_NUMBER.getMessage());
            }
        }
    }
}
