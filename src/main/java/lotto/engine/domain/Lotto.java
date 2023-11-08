package lotto.engine.domain;

import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_LENGTH;

import java.util.HashSet;
import java.util.List;
import lotto.engine.LottoSystemConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.value()) {
            throw new IllegalArgumentException();
        }

        int count = (int) numbers.stream().distinct().count();
        if (count != LOTTO_NUMBER_LENGTH.value()) {
            throw new IllegalArgumentException("유효한 길이가 아닙니다.");
        }

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

        if (count > LottoSystemConstant.LOTTO_MAXIMUM_NUMBER_OF_WINNINGS.value()) {
            count = LottoSystemConstant.LOTTO_MAXIMUM_NUMBER_OF_WINNINGS.value();
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
}
