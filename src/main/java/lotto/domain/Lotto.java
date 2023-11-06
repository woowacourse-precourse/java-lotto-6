package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for(int number : numbers){
            if(!(number>=1 && number<=45)){
                throw new IllegalArgumentException("[ERROR] Winning number should be between 1 and 45.");
            }
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] Numbers shouldn't be duplicated.");
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

}
