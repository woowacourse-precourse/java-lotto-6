package lotto.domain;

import lotto.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicateNumber(numbers);
        for (int number : numbers) {
            validateNumberOutOfRange(number);
        }
        this.lottoNumbers = numbers;
    }

    public List<Integer> getLotto(){
        return lottoNumbers;
    }

    public static void validateNumberCount(List<Integer> numbers) {
        if(numbers.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_CAN_HAVE_ONLY_SIX_NUMBERS);
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers){
        boolean isDuplicate = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (isDuplicate) {
            throw new NumberFormatException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    public static void validateNumberOutOfRange(int lottoNumber) {
        if(lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public static List<Integer> validateNumberSeparate(String[] numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            validateNumbersType(number);
            lottoNumbers.add(Integer.parseInt(number));
        }
        return lottoNumbers;
    }

    public static void validateNumbersType(String number){
        if (!number.matches(NUMBER_REGEX)) {
            throw new NumberFormatException(ErrorMessage.LOTTO_MUST_CONSIST_OF_NUMBERS);
        }
    }
}

