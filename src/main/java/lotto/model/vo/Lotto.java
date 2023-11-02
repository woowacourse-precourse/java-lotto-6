package lotto.model.vo;

import lotto.service.exceptionhandler.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
@DisplayName("private 접근제어자가 붙은 것은 수정하지 못한다는 제약조건")
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
        int LOTTO_TOTAL_CHOICE_MAX_NUMBER = 6;
        if (numbers.size() != LOTTO_TOTAL_CHOICE_MAX_NUMBER){
            throw new IllegalArgumentException
              (LottoErrorMessage.ERROR_LOTTO_NOT_CHOICE_SIX_NUMBER_MESSAGE);
        }
        if (numbers.stream().distinct().count() != LOTTO_TOTAL_CHOICE_MAX_NUMBER){
            throw new IllegalArgumentException
              (LottoErrorMessage.ERROR_LOTTO_OVERLAP_NUMBER_MESSAGE);
        }

        numbers.forEach(this::validateRange);
    }
    private void validateRange(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException
              (LottoErrorMessage.ERROR_LOTTO_OVER_POSITION_NUMBER_MESSAGE);
        }
    }


}
