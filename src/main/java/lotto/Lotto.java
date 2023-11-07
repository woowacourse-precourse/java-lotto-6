package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 같은 로또 번호가 있으면 안됩니다.");
        }
    }
    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public String length(Lotto lotto){
        List<Integer> list = lotto.numbers;
        int[] arr = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }

        return Arrays.toString(arr);
    }


    public List<Integer> size() {
        return numbers;
    }
}
