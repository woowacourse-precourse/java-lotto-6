package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Util.Size;

public class Validation {
    public static void validatePaymentDivisibility(int payment) {
        if (payment % Size.PAYMENT_UNIT.getSize() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Size.LOTTO_SIZE.getSize()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Size.MINIMUM_LOTTO_NUMBER.getSize()
                    || Size.MAXIMUM_LOTTO_NUMBER.getSize() < number) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateLottoDuplication(List<Integer> numbers) {
        Set<Integer> checkDuplication = new HashSet<>(numbers);

        if (checkDuplication.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < Size.MINIMUM_LOTTO_NUMBER.getSize()
                || Size.MAXIMUM_LOTTO_NUMBER.getSize() < bonusNumber) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumberDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
