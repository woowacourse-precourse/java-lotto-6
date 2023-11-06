package lotto;

import java.util.List;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void printLotto(){
        System.out.print("[");
        for (int i = 0; i < LOTTO_SIZE; i++) {
            System.out.print(numbers.get(i));
            if(i!=LOTTO_SIZE-1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
