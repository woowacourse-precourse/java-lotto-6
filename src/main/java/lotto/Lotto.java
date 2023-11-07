package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리 번호로 입력해주세요.");
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호 없이 입력해주세요.");
        }

        numbers.stream().forEach(this::validateLottoNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumber() {
        System.out.println("[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]");
    }

    public int matchCount(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (this.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean containBounsNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    private void validateLottoNumber(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}