package lotto.domain;

import static lotto.domain.constant.CommonMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.constant.Rank;
import lotto.domain.generator.LottoGenerator;
import lotto.view.OutputView;

public class Lotto {
    public static final int LOTTO_NUMBER = 6;
    public static final int LOTTO_RANGE_BEGIN = 1;
    public static final int LOTTO_RANGE_END = 45;
    public static final String LOTTO_OPEN_BRACKET = "[";
    public static final String LOTTO_CLOSE_BRACKET = "]";
    public static final String LOTTO_DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE.getValue());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE.getValue());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> duplicateCheckSet = new HashSet<>();
        numbers.forEach(number -> checkDuplicate(duplicateCheckSet, number));
    }

    private void checkDuplicate(HashSet<Integer> duplicateCheckSet, Integer number) {
        if (duplicateCheckSet.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE.getValue());
        }
        duplicateCheckSet.add(number);
    }

    public static Lotto createLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> numbers = lottoGenerator.generateLottoNumbers();
        return new Lotto(numbers);
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    Rank getRank(WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.countMatchedNumber(this);
        boolean hasBonus = winningNumbers.hasBonusNumber(this);
        return Rank.of(matchCount, hasBonus);
    }

    public void printLotto() {
        OutputView.printMessage(this.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return LOTTO_OPEN_BRACKET +
                numbers.stream()
                        .map(Objects::toString)
                        .collect(Collectors.joining(LOTTO_DELIMITER)) +
                LOTTO_CLOSE_BRACKET;
    }
}
