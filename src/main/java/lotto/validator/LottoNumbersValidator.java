package lotto.validator;

import java.util.List;

public class LottoNumbersValidator implements InputValidator{
    @Override
    public void validate(String input) {
        input = input.replaceAll("\\s", "");
        List<String> lottoNumbers = List.of(input.split(","));

        LottoValidator.validateDuplicatedNumber(lottoNumbers);
        LottoValidator.validateIsProperSize(lottoNumbers);

        for (String number : lottoNumbers) {
            CommonValidator.validateIsNaturalNumber(number);
            int num = Integer.parseInt(number);

            LottoValidator.validateRangeOfNumber(num);
        }
    }
}
