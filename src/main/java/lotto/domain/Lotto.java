package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.impl.RandomNumberImpl.END_NUM;
import static lotto.impl.RandomNumberImpl.START_NUM;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력 할 수 있습니다.");
        }
        if(isDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력 할 수 없습니다.");
        }
        for(int num : numbers) {
            if(!isInRange(num)) {
                throw new IllegalArgumentException("[ERROR] 1~45 까지의 수를 입력해주세요");
            }
        }
    }

    private boolean isDuplicate(List<Integer> winningNumbers) {
        return winningNumbers.stream().distinct().count() != 6;
    }

    static boolean isInRange(int number) {
        return number >= START_NUM && number <= END_NUM;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void sort() {
        Collections.sort(numbers);
    }

}
