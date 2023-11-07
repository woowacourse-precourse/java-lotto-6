package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        for(int num : numbers){
            validateNum(num);
        }
        validDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateNum(int num) {
        if(num < 0 || num > 45) {
            throw new IllegalArgumentException("[Error] 1부터 45사이 숫자만 입력하세요.");
        }
    }

    public void validDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (Integer number : numbers) {
            if (set.contains(number)) {
                throw new IllegalArgumentException("[Error] 로또 번호에 중복된 숫자가 있습니다.");
            }
            set.add(number);
        }
    }


}
