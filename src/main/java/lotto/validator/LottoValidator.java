package lotto.validator;

import lotto.domain.ErrorMessage;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;


public class LottoValidator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

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

    public static void validateNumberOutOfRange(int lottoNumber) {
        if(lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
        }
    }

}
