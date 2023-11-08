package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public int howMany(List<Integer> numbers){
        int howMany=0;
        for(int number:numbers){
            howMany=isContained(number, howMany);
        }
        return howMany;
    }
    public int isContained(int n, int value) {
        if (numbers.contains(n)) {
            value++;
            return value;
        }
        else return value;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
