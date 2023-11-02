package lotto.model.vo;

import lotto.service.exceptionhandler.LottoErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Integer> numbers;
    public LottoNumbers(List<Integer> numbers){
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }
    public List<Integer> getNumbers(){
        return Collections.unmodifiableList(numbers);
    }
    private void validate(List<Integer> numbers){
        if(numbers.size() != LOTTO_TOTAL_CHOICE_MAX_NUMBER){
            throw new IllegalArgumentException(LottoErrorMessage.ERROR_LOTTO_NOT_CHOICE_SIX_NUMBER_MESSAGE);
        }
        if(numbers.stream().distinct().count() != LOTTO_TOTAL_CHOICE_MAX_NUMBER){
            throw new IllegalArgumentException(LottoErrorMessage.ERROR_LOTTO_OVERLAP_NUMBER_MESSAGE);
        }
        numbers.forEach(this::validateRange);
    }
    private void validateRange(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException(LottoErrorMessage.ERROR_LOTTO_OVER_POSITION_NUMBER_MESSAGE);
        }
    }
    @Override
    public String toString() {
        return numbers.stream()
          .map(String::valueOf)
          .collect(Collectors.joining(", "));
    }
    private static final int LOTTO_TOTAL_CHOICE_MAX_NUMBER = 6;
}
