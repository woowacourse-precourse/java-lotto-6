package lotto.domain;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.CommonLetter;
import lotto.validator.impl.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        validate(numbers);
        this.numbers = toNumbers(numbers);
    }

    private void validate(String numbers) {
        new LottoValidator().validate(numbers);
    }

    public void print() {
        System.out.println(numbers);
    }

    List<Integer> toNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(CommonLetter.SEPARATOR.getLetter()))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public BitSet toBitSet() {
        BitSet bitSet = new BitSet();
        for (int number : numbers) {
            bitSet.set(number);
        }
        return bitSet;
    }

    public int getWinningCount(BitSet winningNumberBitSet) {
        int winningCount = 0;
        for (int number : numbers) {
            if (winningNumberBitSet.get(number)) {
                winningCount++;
            }
        }
        return winningCount;
    }

    public boolean containsBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }
}
