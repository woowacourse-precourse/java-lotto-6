package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    PrintError printError = new PrintError();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }



    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        duplicateValidate(numbers);
    }

    private void sizeValidate(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(printError.countERROR());
        }
    }
    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size() != numbers.size()){
            throw new IllegalArgumentException(printError.duplicateError());
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }


    // TODO: 추가 기능 구현
}
