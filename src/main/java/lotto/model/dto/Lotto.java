package lotto.model.dto;

import lotto.service.exceptionhandler.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.stream.Collectors;

@DisplayName("사용자가 구매하는 로또 번호 저장")
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        realValidateAll(numbers);
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    private void realValidateAll(List<Integer> numbers){
        int LOTTO_TOTAL_CHOICE_MAX_NUMBER_OF_SIX = 6;
        if (numbers.size() != LOTTO_TOTAL_CHOICE_MAX_NUMBER_OF_SIX){
            throw new IllegalArgumentException
              (LottoErrorMessage.ERROR_LOTTO_NOT_CHOICE_SIX_NUMBER_MESSAGE);
        }
        if (numbers.stream().distinct().count() != LOTTO_TOTAL_CHOICE_MAX_NUMBER_OF_SIX){
            throw new IllegalArgumentException
              (LottoErrorMessage.ERROR_LOTTO_OVERLAP_NUMBER_MESSAGE);
        }
        numbers.forEach(this::validateRange);
    }
    protected void validateRange(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException
              (LottoErrorMessage.ERROR_LOTTO_OVER_POSITION_NUMBER_MESSAGE);
        }
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
    @Override
    public String toString() {
        return numbers.stream()
          .map(String::valueOf)
          .collect(Collectors.joining(", "));
    }

}
