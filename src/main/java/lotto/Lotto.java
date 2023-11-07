package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void printNumbers(){
        System.out.print("[");
        for (int i = 0; i < this.numbers.size(); i++){
            System.out.print(this.numbers.get(i));
            if ( i != (this.numbers.size() - 1) ){
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }

    // TODO: 추가 기능 구현
}
