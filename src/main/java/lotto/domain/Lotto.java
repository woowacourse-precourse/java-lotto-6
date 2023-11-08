package lotto.domain;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countContainNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::containNumber)
                .count();
    }

    private boolean containNumber(Integer number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers){
        validateNumberAndCount(numbers);
        checkDuplicate(numbers);
    }


    private void validateNumberAndCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개 입력하세요.");
        }

        for (int value : numbers) {
            validateInRange(value);
        }

    }

    private void validateInRange(final int value) {
        if (value < LOTTO_NUMBER_START || value > LOTTO_NUMBER_END) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위가 벗어났습니다.");
        }
    }

    private void checkDuplicate(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);

        if(numberSet.size() <6){
            throw new IllegalArgumentException("[ERROR] 중복값 입력하셨습니다.");
        }

    }


}
