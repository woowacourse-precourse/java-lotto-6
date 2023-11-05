package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplication(List<Integer> numbers) {
        boolean check[] = new boolean[46];
        for (int i = 0; i < numbers.size(); ++i) {
            if (check[numbers.get(i)]) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 중복 되었습니다.");
            }
            check[numbers.get(i)] = true;
        }
    }


}
