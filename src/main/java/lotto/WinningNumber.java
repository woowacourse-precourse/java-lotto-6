package lotto;

import java.util.List;
import java.util.Arrays;

import static lotto.LottoProperty.LOTTO_MIN_NUMBER;
import static lotto.LottoProperty.LOTTO_MAX_NUMBER;
import static lotto.LottoProperty.LOTTO_NUMBER_SIZE;

public class WinningNumber {
    public static final String SPLITOR = ",";
    private final List<Integer> winningNumbers;

    public WinningNumber(String stringNumbers) {
        validate(stringNumbers);
        this.winningNumbers = Arrays.stream(stringNumbers.split(SPLITOR))
                .map(Integer::parseInt)
                .toList();
    }

    private void validate(String stringNumbers) {
        List<Integer> numbers = validateNumber(stringNumbers);
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private List<Integer> validateNumber(String stringNumbers) {
        try {
            return Arrays.stream(stringNumbers.split(SPLITOR))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE.getLottoProperty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 숫자여야 합니다");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().mapToInt(v -> v).min().orElse(0) < LOTTO_MIN_NUMBER.getLottoProperty() ||
                numbers.stream().mapToInt(v -> v).max().orElse(0) > LOTTO_MAX_NUMBER.getLottoProperty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다");
        }
    }

    public int checkLotto(List<Integer> numbers, BonusNumber bonus) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
            if (count == 5) {
                count += 2 * Boolean.compare(bonus.checkBonus(numbers), false);
            }
        }
        return switchRanking(count);
    }

    private int switchRanking(int ranking) {
        if (ranking == 7) {
            return 6;
        }
        if (ranking == 6) {
            return 7;
        }
        return ranking;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
