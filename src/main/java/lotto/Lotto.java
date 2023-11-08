package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        List<Integer> number = new ArrayList<>(numbers);
        Collections.sort(number);
        return number;
    }

    public void validate(List<Integer> numbers) {
        validateSize(numbers.size());
        validateEmpty(numbers);
        validate1to45(numbers);
        validateDuplication(numbers);
    }

    public void validate1to45(List<Integer> numbers) {
        for(int num : numbers) {
            if(num < 1 || num > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateEmpty(List<Integer> numbers) {
        if(numbers.isEmpty()){
            System.out.println("2");
            throw new IllegalArgumentException();
        }
    }

    public void validateSize(int size) {
        if(size != 6){
            System.out.println("3");
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            OutputError.error_duplication();
            throw new IllegalArgumentException();
        }
    }
}
