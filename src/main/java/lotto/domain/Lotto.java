package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoGenerator.PICK_NUMBER) {
            System.out.println("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
            BallNumber.canUse = true;
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }

        if (hasDuplicate(numbers)) {
            System.out.println("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            BallNumber.canUse = true;
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }

        if (numbers.stream().anyMatch(number -> number < LottoGenerator.MIN_NUMBER || number > LottoGenerator.MAX_NUMBER)) {
            System.out.println("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            BallNumber.canUse = true;
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }

        if (numbers.stream().anyMatch(number -> !String.valueOf(number).matches("[0-9]+"))) {
            System.out.println("[ERROR] 숫자와 ','만 입력가능합니다.");
            BallNumber.canUse = true;
            throw new IllegalArgumentException("[ERROR] 숫자와 ','만 입력가능합니다.");
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