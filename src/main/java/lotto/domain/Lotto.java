package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1_000;
    public static final int LOTTO_NUMBER_LENGTH = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicated(numbers);

        this.numbers = mapToAscendingLottoNumbers(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d자리입니다.", LOTTO_NUMBER_LENGTH));
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private static List<LottoNumber> mapToAscendingLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    public int matchCount(Lotto other) {
        return (int) other.numbers.stream()
                .filter(this::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
