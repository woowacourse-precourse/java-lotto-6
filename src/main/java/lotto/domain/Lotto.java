package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            if (numbers.size() != LottoGenerator.PICK_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
            }

            if (numbers.stream().anyMatch(number -> number < LottoGenerator.MIN_NUMBER || number > LottoGenerator.MAX_NUMBER)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            }

            if (numbers.stream().anyMatch(number -> !String.valueOf(number).matches("[0-9]+"))) {
                throw new IllegalArgumentException("[ERROR] 숫자와 ','만 입력가능합니다.");
            }

            if (hasDuplicate(numbers)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            BallNumber.canUse = true;
        }

    }

    // TODO: 추가 기능 구현
    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}