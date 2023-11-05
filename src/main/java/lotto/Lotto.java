package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    ExceptionCases exceptionCases = new ExceptionCases();

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNum(numbers);
        validateDup(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        exceptionCases.CheckSize(numbers);
    }
    private void validateNum(List<Integer> numbers){
        exceptionCases.CheckNum(numbers);
    }
    private void validateDup(List<Integer> numbers){
        exceptionCases.CheckDuplicate(numbers);
    }


    public List<Integer> getNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
