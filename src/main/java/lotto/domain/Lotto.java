package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(!isCorrectSize(numbers)) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어야 합니다.");
        }
        if(!isInRange(numbers)) {
            throw new IllegalArgumentException("1~45 사이의 숫자만 가능합니다.");
        }
        if(!isUniqueNumbers(numbers)) {
            throw new IllegalArgumentException("중복된 숫자는 불가능합니다.");
        }
        if(!isAscending(numbers)){
            throw new IllegalArgumentException("오름차순으로 정렬되어야 합니다.");
        }
    }

    private boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isInRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < LOTTO_NUMBER_RANGE_MIN || number > LOTTO_NUMBER_RANGE_MAX)
                return false;
        }
        return true;
    }

    private boolean isUniqueNumbers(List<Integer> numbers) {
        boolean[] isContained = new boolean[LOTTO_NUMBER_RANGE_MAX+1];
        for(Integer number : numbers) {
            if(isContained[number]) {
                return false;
            }
            isContained[number] = true;
        }
        return true;
    }

    private boolean isAscending(List<Integer> numbers) {
        for(int i = 1; i< numbers.size(); i++) {
            if(numbers.get(i) < numbers.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
