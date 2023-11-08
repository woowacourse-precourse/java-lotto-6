package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicates(numbers);
        this.numbers = numbers ;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 가능합니다.");
        }
    }

    private void checkDuplicates(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자는 불가능합니다.");
            }
        }

    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
