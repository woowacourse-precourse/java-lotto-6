package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 6개의 숫자로만 구성되어 있어야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복되지 않은 숫자로 구성되어 있어야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 1 ~ 45 범위의 숫자로 구성되어 있어야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public boolean isAleadyIn(int number) {
        return numbers.contains(number);
    }

    public int judge(Lotto winningLotto, BonusNumber bonusNumber) {
        int size = deduplicateSize(winningLotto);
        int sameCount = getSameCount(size);

        if (sameCount == 5) {
            return caculate2Or3Rank(bonusNumber);
        }

        return calculateRank(sameCount);
    }

    private int deduplicateSize(Lotto winningLotto) {
        HashSet<Integer> deduplicater = new HashSet<>();
        deduplicater.addAll(numbers);
        deduplicater.addAll(winningLotto.getSortedNumbers());

        return deduplicater.size();
    }

    private int getSameCount(int size) {
        return LOTTO_SIZE * 2 - size;
    }

    private int calculateRank(int sameCount) {
        Map<Integer, Integer> rankByCount = Map.of(
                6, 1,
                4, 4,
                3, 5
        );

        if (rankByCount.containsKey(sameCount)) {
            return rankByCount.get(sameCount);
        }

        return -1;
    }

    private int caculate2Or3Rank(BonusNumber bonusNumber) {
        if (isSecondRank(bonusNumber)) {
            return 2;
        }
        return 3;
    }

    private boolean isSecondRank(BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(bonusNumber::isEqual);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> deduplicateNumbers = new HashSet<>(numbers);
        if (deduplicateNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(value -> {
                    throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
                });
    }
}
