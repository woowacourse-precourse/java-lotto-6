package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class Winning extends LottoRule{
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers){
        if(isMismatchLength(numbers)){
            ExceptionMessage.LOTTO_MISMATCH_LENGTH.throwException();
        }
    }
}
