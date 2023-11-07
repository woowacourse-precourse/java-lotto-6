package lotto;

import java.util.ArrayList;
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
        List<Integer> UserInput = new ArrayList<>();
        for (Integer number : numbers) {
            int digit = Integer.parseInt(String.valueOf(number));
            if ( !UserInput.contains(digit) ) {
                UserInput.add(digit);
                continue;
            }
            System.out.println("[ERROR] 로또 번호는 6개의 중복되지 않는 정수여야 합니다.");
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

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    // TODO: 추가 기능 구현
}
