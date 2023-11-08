package lotto;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateSameNum(numbers);

    }

    private void validateSameNum(List<Integer> numbers) {
        Set<Integer> checkSameNum = new HashSet<>(numbers);
        if(checkSameNum.size() != numbers.size()) throw new IllegalArgumentException("[ERROR]동일한 로또 번호가 있으면 안됩니다.");
    }

    private void validateRange(List<Integer> numbers) {
        for(int number : numbers){
            if(number<1 || number>45) throw new IllegalArgumentException("[ERROR]로또 번호는 1~45사이의 숫자만 가능합니다.");
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
