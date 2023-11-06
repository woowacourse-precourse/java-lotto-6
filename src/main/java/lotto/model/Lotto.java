package lotto.model;

import java.util.List;
import lotto.model.Errors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumberRange (List<Integer> numbers) {
        for(int num : numbers) {
            Errors.isWrongRange(num);
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate (List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++) {
            if(isContain(numbers, numbers.get(i), i+1)) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    public int getNumber(int idx) {
        return this.numbers.get(idx);
    }

    public List<Integer> getLotto () {
        return this.numbers;
    }
    public int countMatch (Lotto answers, int bonus) {
        int result = 0;
        for(int i = 0; i < this.numbers.size(); i++) {
            if(isContain(numbers, answers.getNumber(i),0)) {
                result++;
            }
        }

        if(result == 5 && isContain(numbers, bonus, 0)) {
            result=-1;
        }

        return result;
    }
    private boolean isContain (List<Integer> numbers, int num, int start) {
        for(int i = start; i < numbers.size(); i++) {
            if(numbers.get(i) == num) {
                return true;
            }
        }
        return false;
    }
}
