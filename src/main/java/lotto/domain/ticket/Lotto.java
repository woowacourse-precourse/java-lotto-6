package lotto.domain.ticket;

import static lotto.domain.ticket.LottoErrorMessage.DUPLICATION_ERROR;
import static lotto.domain.ticket.LottoErrorMessage.INVALID_RANGE_ERROR;
import static lotto.domain.ticket.LottoErrorMessage.SIZE_ERROR;
import static lotto.domain.ticket.LottoNumberConfig.MAXIMUM_RANGE;
import static lotto.domain.ticket.LottoNumberConfig.MINIMUM_RANGE;
import static lotto.domain.ticket.LottoNumberConfig.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.dto.LottoResult;
import lotto.domain.winningnumbers.WinningNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public LottoResult getResult(WinningNumbers winningNumbers) {
        return new LottoResult(getCountOfSameNumber(winningNumbers),
                isContainBonusNumber(winningNumbers));
    }

    private void validate(List<Integer> numbers) {
        if(validateSize(numbers)) {
            throw new IllegalArgumentException(SIZE_ERROR.getMessage());
        }
        if(validateDuplication(numbers)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
        if(validateRange(numbers)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR.getMessage());
        }
    }


    private int getCountOfSameNumber(WinningNumbers winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers::isInWinningNumbers)
                .toList()
                .size();
    }

    private boolean isContainBonusNumber(WinningNumbers winningNumbers) {
        return !numbers.stream()
                .filter(winningNumbers::isSameWithBonusNumber)
                .toList()
                .isEmpty();
    }
    private boolean validateSize(List<Integer> numbers) {
        return  (numbers.size() != NUMBER_COUNT.getValue());
    }

    private boolean validateDuplication(List<Integer> numbers) {
        return (numbers.stream()
                .distinct()
                .count() != NUMBER_COUNT.getValue());
    }

    private boolean validateRange(List<Integer> numbers) {
        return !numbers.stream()
                .filter(number -> number < MINIMUM_RANGE.getValue() ||
                        number > MAXIMUM_RANGE.getValue())
                .toList()
                .isEmpty();
    }


}
