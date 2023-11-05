package lotto.validator;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;


public class LottoValidator {

    public static List<Integer> makeLotto(String[] numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        return lottoNumbers;
    }

    public static List<Integer> validateLottoNumbers(String[] numbers){
        validateNumberSeparate(numbers);

        List<Integer> lottoNumbers = makeLotto(numbers);
        validateDuplicateNumber(new Lotto(lottoNumbers));

        for(int number : lottoNumbers){
            validateNumberOutOfRange(number);
        }

        return lottoNumbers;
    }
}
