package lotto.Model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) throw new IllegalArgumentException();
    }

    public void outputLottoNum() {
        System.out.print("[");
        for(int i = 0; i<this.numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if(i != numbers.size()-1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}