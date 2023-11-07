package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또를 생성하기 위한 숫자의 개수는 6개 입니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>();
        for(Integer num : numbers){
            if(!numberSet.add(num)){
                throw new IllegalArgumentException("[ERROR] 중복된 수로는 생성할 수 없습니다.");
            }
        }
    }



    public List<Integer> getLotto() {
        return this.numbers;
    }

    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
