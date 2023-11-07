package lotto.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.MultiplePureNumbers;
import lotto.common.PureNumber;
import lotto.exception.DuplicatedNumberException;
import lotto.exception.InvalidSizeException;

public class LotteryTicket {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN_INCLUDE = 1;
    private static final int LOTTO_NUMBER_MAX_INCLUDE = 45;
    private final List<Integer> numbers;

    public static LotteryTicket create(MultiplePureNumbers numbers) throws IllegalArgumentException {
        return new LotteryTicket(numbers);
    }

    public LotteryTicket(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    public int countHitNumbers(LotteryTicket winningLotteryTicket) {
        int hit = 0;
        for (int number: winningLotteryTicket.numbers) {
            if (this.numbers.contains(number))
                hit++;
        }
        return hit;
    }

    private LotteryTicket(MultiplePureNumbers multiplePureNumbers) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        for (PureNumber pureNumber : multiplePureNumbers.getPureNumbers()) {
            numbers.add(pureNumber.getNumber());
        }
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new InvalidSizeException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.stream().distinct().collect(Collectors.toList()).size() < LOTTO_NUMBERS_SIZE) {
            throw new DuplicatedNumberException();
        }
    }

    private void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number: numbers) {
            if (number < LOTTO_NUMBER_MIN_INCLUDE || number > LOTTO_NUMBER_MAX_INCLUDE) {
                throw new InvalidSizeException();
            }
        }
    }

    public boolean containsBonusNumber(BonusNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.getBonusNumber());
    }

    public boolean containsGivenNumber(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
