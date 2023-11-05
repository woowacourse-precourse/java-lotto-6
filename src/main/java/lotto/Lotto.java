package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해주세요.");
        }

        for (Integer number : numbers) {
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 수를 입력해주세요.");
            }
        }

        System.out.println(numbers);
    }
}
