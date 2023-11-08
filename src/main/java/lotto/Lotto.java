package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
            validate(numbers.stream().distinct().toList());
            this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            System.out.println(ExceptionMessage.당첨번호_6개가아닌경우);
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
