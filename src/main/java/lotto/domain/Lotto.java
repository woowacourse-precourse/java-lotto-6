package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해주세요.");
        validateDuplicate(numbers);
        validateInputRange(numbers);
    }

    private void validateInputRange(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.stream().anyMatch(integer -> integer > 45 || integer < 1))
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요.");
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) throw new IllegalArgumentException("[ERROR] 중복값이 존재합니다.");
    }

    public Integer countMatchingNumber(Lotto winningLotto, Integer bonusNumber) {
        int matchCount = (int) winningLotto.numbers.stream().filter(this.numbers::contains).count();
        if (matchCount < 3) matchCount = 0;
        if (this.numbers.contains(bonusNumber)) matchCount++;
        return matchCount;
    }

    public Boolean checkMatchingNumber(Integer bonusNumber) {
        if (this.numbers.contains(bonusNumber)) return true;
        return null;
    }

    public void displayLotto() {
        String joinedNumbers = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("[" + joinedNumbers + "]");
    }

}
