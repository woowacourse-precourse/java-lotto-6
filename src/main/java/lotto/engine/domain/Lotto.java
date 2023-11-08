package lotto.engine.domain;

import static lotto.engine.LottoSystemConstant.LOTTO_MAXIMUM_NUMBER_OF_WINNINGS;
import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_LENGTH;
import static lotto.engine.LottoSystemConstant.TextMessage.ERROR_PREFIX;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validSize(numbers.size(), "유효한 길이가 아닙니다.");
        validNonDuplicateNumbers(numbers);
    }

    public String showNumbers() {
        return numbers.toString();
    }

    public int matchCount(Customer customer) {
        HashSet<Integer> winingNumbers = new HashSet<>(customer.getWinningNumbers());

        int count = 0;
        if (winingNumbers.contains(customer.getBonusNumber())) {
            count++;
        }

        count += (int) numbers.stream().filter(winingNumbers::contains)
                .count();

        boolean isExceedFixedValue = count > LOTTO_MAXIMUM_NUMBER_OF_WINNINGS.value();
        if (isExceedFixedValue) {
            count = LOTTO_MAXIMUM_NUMBER_OF_WINNINGS.value();
        }

        return count;
    }

    public boolean isMatchSpecialCondition(Customer customer, int correctNumber) {
        HashSet<Integer> winingNumbers = new HashSet<>(customer.getWinningNumbers());

        int bonusNumber = customer.getBonusNumber();
        int count = (int) numbers.stream().filter(winingNumbers::contains)
                .count();

        return !winingNumbers.contains(bonusNumber) && count == correctNumber;
    }

    private void validSize(int numbers, String x) {
        if (numbers != LOTTO_NUMBER_LENGTH.value()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + x);
        }
    }

    private void validNonDuplicateNumbers(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();
        if (count != LOTTO_NUMBER_LENGTH.value()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + "중복된 숫자가 존재합니다.");
        }
    }
}
