package Model;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validate6numbers(numbers);
        validate1to45(numbers);
        validateNotEqual(numbers);
    }

    private void validate6numbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validate1to45(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateNotEqual(List<Integer> numbers) {
        Set<Integer> numbersNotSame = new HashSet<>();
        for (int number : numbers) {
            if (!numbersNotSame.add(number)) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 중복 숫자가 없어야 합니다.");
            }
        }
    }

    public int howManySameNumbers(Lotto lotto) {
        long sameNumberCount = numbers.stream()
                .filter(lotto.numbers::contains)
                .count();

        return (int) sameNumberCount;
    }

    public boolean isContains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.get());
    }

    public int getSize() {
        return numbers.size();
    }

    public int getItem(int idx) {
        return numbers.get(idx);
    }

    public List<Integer> getSortedLotto() {
        List<Integer> sortLotto = new ArrayList<>(numbers);
        Collections.sort(sortLotto);
        return sortLotto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto other = (Lotto) obj;
        return numbers.equals(other.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
