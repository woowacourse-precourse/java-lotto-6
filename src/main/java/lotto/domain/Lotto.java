package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static lotto.GameConfig.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.GameConfig.LOTTO_NUMBER_UPPER_BOUND;
import static lotto.util.LottoNumberGenerator.generateRandomLottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    public static Lotto generateRandomLotto() {
        return new Lotto(generateRandomLottoNumber());
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        numbers.forEach(Lotto::validateRangeOfNumber);
    }

    private static void validateRangeOfNumber(int number) {
        if (hasInvalidRange(number)) {
            throw new IllegalArgumentException("1에서 45 사이의 정수를 입력해주십시오.");
        }
    }

    private static boolean hasInvalidRange(int number) {
        return number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND;
    }
    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 여섯 개여야 합니다.");
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (containsDuplication(numbers)) {
            throw new IllegalArgumentException("로또 번호에는 중복이 존재할 수 없습니다.");
        }
    }

    private static boolean containsDuplication(List<Integer> numbers) {
        long distinctNumberCount = numbers.stream()
                .distinct()
                .count();
        return distinctNumberCount != numbers.size();
    }

    public Rank calculateRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchingNumberCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        int matchingBonusNumberCount = (int) numbers.stream()
                .filter(number -> number == bonusNumber)
                .count();

        return Rank.findByMatchingNumber(matchingNumberCount, matchingBonusNumberCount);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
