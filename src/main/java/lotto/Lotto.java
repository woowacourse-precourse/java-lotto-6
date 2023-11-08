package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 1개의 로또를 발행할 때 6개의 숫자를 전달해야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 1개의 로또를 발행할 때 중복되지 않는 숫자를 전달해야 합니다.");
        }
        for (Integer number : numbers) {
            if (number < LottoEnum.NUMBER_MIN.getValue() || LottoEnum.NUMBER_MAX.getValue() < number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 "
                        + LottoEnum.NUMBER_MIN.getValue()
                        + "부터 "
                        + LottoEnum.NUMBER_MAX.getValue()
                        + " 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
