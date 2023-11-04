package lotto.domain.lotto;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBERS = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        verifyNumbersSize(numbers);
        verifyNoDuplication(numbers);
        verifyLottoNumberRange(numbers);
        this.numbers = sort(numbers);
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void verifyNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBERS + "개여야 합니다.");
        }
    }

    private void verifyNoDuplication(List<Integer> numbers) {
        int uniqueCount = getUniqueCount(numbers);
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복되는 숫자가 있으면 안 됩니다.");
        }
    }

    private int getUniqueCount(List<Integer> numbers) {
        return (int) numbers.stream().distinct().count();
    }

    private void verifyLottoNumberRange(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_NUMBER + "에서 " + MAX_NUMBER + "사이의 숫자만 가능합니다.");
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getLottoNumbers() {
        return List.copyOf(numbers);
    }
}

