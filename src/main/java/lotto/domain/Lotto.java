package lotto.domain;

import lotto.exception.InvalidBallException;
import lotto.exception.InvalidLottoNumbersException;
import lotto.utils.LottoWinningStrategy;

import java.util.*;

public class Lotto {
    private static final int DEFAULT_LOTTO_SIZE = 6;
    private static final double MIN_RANGE = 1;
    private static final double MAX_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueBalls = new HashSet<>(numbers);
        if (uniqueBalls.size() != DEFAULT_LOTTO_SIZE) {
            throw new InvalidLottoNumbersException();
        }
        for (Integer ball : uniqueBalls) {
            if (ball < MIN_RANGE || ball > MAX_RANGE) {
                throw new InvalidBallException();
            }
        }
    }

    public Result determineResult(LottoWinningStrategy winningStrategy, List<Integer> winningNumbers, int bonusBall) {
        return winningStrategy.determineResult(numbers, winningNumbers, bonusBall);
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }
}
