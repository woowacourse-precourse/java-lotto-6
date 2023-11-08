package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요");
        }
        if (numbers.stream().allMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("번호는 전부 1에서 45 사이의 수여야 합니다");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해 주세요");
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public int calculateScore(Lotto answer) {
        long count = numbers.stream()
                .filter(number -> answer.getNumbers().contains(number))
                .count();

        return (int) count;
    }



    public boolean hasBonus(int bonusNum) {
        return numbers.contains(bonusNum);
    }


}
