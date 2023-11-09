package lotto;

import static lotto.Constants.LottoConstant.*;
import static lotto.Constants.MessageConstant.COMMA_BLANK_DELIMITER;
import static lotto.Constants.MessageConstant.LOTTO_NUMBER_MESSAGE;
import static lotto.Constants.NumberOfLottoCorrect.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.Constants.NumberOfLottoCorrect;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        validateSize(numbers.size());
        validateDuplication(numbers);
    }

    public String showNumbers() {
        String numbers = this.numbers.stream()
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining(COMMA_BLANK_DELIMITER));
        return
            LOTTO_NUMBER_MESSAGE.formatted(numbers);
    }

    public NumberOfLottoCorrect compareWinningNumber(WinningNumber winningNumber,
        LottoNumber bonusNumber) {
        int correctCount = (int) numbers.stream()
            .filter(winningNumber::hasNumber)
            .count();
        boolean hasBonus = numbers.stream()
            .anyMatch(bonusNumber::isSame);
        if (hasBonus) {
            correctCount++;
        }
        return getNumberOfLottoCorrect(correctCount, hasBonus);
    }

    private static NumberOfLottoCorrect getNumberOfLottoCorrect(int correctCount,
        boolean hasBonus) {
        for (NumberOfLottoCorrect numberOfLottoCorrect : NumberOfLottoCorrect.values()) {
            if (correctCount == FIVE_BONUS_MATCHES.getMatchCount() && hasBonus) {
                return FIVE_BONUS_MATCHES;
            }
            if (correctCount == SIX_MATCHES.getMatchCount()) {
                return SIX_MATCHES;
            }
            if (numberOfLottoCorrect.getMatchCount() == correctCount) {
                return numberOfLottoCorrect;
            }
        }
        return TWO_LESS_MATCHES;
    }

    private void validateSize(int numbers) {
        if (numbers != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        numbers.stream().forEach(uniqueNumbers::add);
        validateSize(uniqueNumbers.size());
    }
}
