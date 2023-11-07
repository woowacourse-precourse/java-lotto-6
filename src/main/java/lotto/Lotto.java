package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Set<Integer> duplicateNumber = new HashSet<>(numbers);
        if(duplicateNumber.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력하세요.");
        }
        
        System.out.println(numbers);
    }
}
