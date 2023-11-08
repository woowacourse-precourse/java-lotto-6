package lotto.model;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.DUPLICATED_NUMBER;
import static lotto.constants.ExceptionMessages.INVALID_RANGE;
import static lotto.constants.ExceptionMessages.INVALID_TOTAL_NUMBER;
import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.NUMBER_OF_LOTTO_NUMBERS;

import java.util.List;
import lotto.constants.ExceptionMessages;
import lotto.constants.LottoConstants;
import lotto.converter.MessageConverter;
import lotto.model.dto.WinningNumDTO;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_TOTAL_NUMBER);
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(CATCH_ERROR + DUPLICATED_NUMBER);
        }
        if (isWithinRange(numbers)) {
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_RANGE);
        }
    }

    private boolean isWithinRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER);
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() < numbers.size();
    }

    public String writePurchasedLotto() {
        return MessageConverter.writePurchasedLotto(numbers);
    }

    public Ranking checkResult(WinningNumDTO winningNumDTO) {
        int correct = getNumOfCorrect(winningNumDTO.getWinningNums());
        return Ranking.of(correct, isBonus(winningNumDTO.getBonus()));
    }

    private int getNumOfCorrect(List<Integer> winningNums) {
        return (int) winningNums.stream().filter(num -> numbers.contains(num)).count();
    }

    private boolean isBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
