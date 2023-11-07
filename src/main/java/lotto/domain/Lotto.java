package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자여야 합니다.");
        }
        if(numbers.stream().distinct().count() != LOTTO_COUNT){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력 할 수 없습니다.");
        }
        for(int number : numbers) {
            if(number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 1~45 까지의 수를 입력해주세요");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}