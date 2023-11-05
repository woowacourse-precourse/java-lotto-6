package lotto.validator;

import lotto.domain.ErrorMessage;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.ErrorMessage.*;

public class LottoValidator {

    private static final String NUMBER_REGEX = "^[0-9]+$";
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

    public static void validateNumberSeparate(String[] numbers) {
        for (String number : numbers) {
            validateNumbersType(number);
        }
    }

    public static void validateDuplicateNumber(Lotto lotto){
        boolean isDuplicate = lotto.getLotto().stream()
                .distinct()
                .count() != lotto.getLotto().size();

        if (isDuplicate) {
            throw new NumberFormatException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    public static void validateNumbersType(String number){
        if (!number.matches(NUMBER_REGEX)) {
            throw new NumberFormatException(ErrorMessage.LOTTO_MUST_CONSIST_OF_NUMBERS);
        }
    }

    public static void validateNumberOutOfRange(int lottoNumber) {
        if(lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public static void validateBonusNumberInWinningNumbers(Lotto lotto, int bonusNumber){
        List<Integer> lottoNumbers = lotto.getLotto();
        if(lottoNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_ALREADY_IN_WINNING_ERROR);
        }
    }

}
