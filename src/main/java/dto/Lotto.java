package dto;

import constant.Constants;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void showLottoNumbers() {
        System.out.print(Constants.PRINT_LOTTO_START);
        for (int i = 0; i < 5; i++) {
            System.out.print(numbers.get(i) + Constants.COMMA_AND_SPACE);
        }
        System.out.println(numbers.get(5) + Constants.PRINT_LOTTO_END);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
