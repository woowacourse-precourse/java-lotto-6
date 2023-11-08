package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateIsNull(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    public boolean contains(int number) {

    }

    public static List<Integer> createLotto() {

    }

    public Rank getRank(Lotto winNumbers, Bonus bonus) {

    }

    public String getLottoNumber(){

    }

    private int getCorrectCount(Lotto winNumbers) {

    }

    private void validateSize(List<Integer> numbers) {

    }

    private void validateDuplicate(List<Integer> numbers) {

    }

    private void validateIsNull(List<Integer> numbers) {

    }

    private void validateNumberRange(List<Integer> numbers) {

    }
}
