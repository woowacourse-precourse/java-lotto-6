package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.PrintError;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());

    }



    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        duplicateValidate(numbers);
    }

    private void sizeValidate(List<Integer> numbers){
        if (numbers.size() != 6) {
            System.out.println(PrintError.countERROR());
            throw new IllegalArgumentException();
        }
    }
    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size() != numbers.size()){
            System.out.println(PrintError.duplicateError());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }


    // TODO: 추가 기능 구현
}
