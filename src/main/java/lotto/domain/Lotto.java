package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
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
