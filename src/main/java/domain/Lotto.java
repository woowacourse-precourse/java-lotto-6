package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String IS_NOT_OVERLAP_SIX_VALIDATOR_ERROR_MESSAGE = "[ERROR] 6개의 숫자에 중복된 로또 번호가 존재합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersLength(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isNotOverlapSixValidator(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(Integer number : numbers){
            if(!uniqueNumbers.add(number)){
                throw new IllegalArgumentException(IS_NOT_OVERLAP_SIX_VALIDATOR_ERROR_MESSAGE);
            }
        }
    }

    // TODO: 추가 기능 구현
}
