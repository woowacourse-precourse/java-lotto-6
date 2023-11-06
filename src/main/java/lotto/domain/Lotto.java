package lotto.domain;

import java.util.BitSet;
import java.util.List;
import lotto.util.Parser;
import lotto.validator.impl.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(flatten(numbers));
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

    private List<Integer> toNumbers(String winningNumbers) {
        return Parser.parseToIntegerList(winningNumbers);
    }

    public BitSet toBitSet() {
        return Parser.parseToBitSet(numbers);
    }

    public String flatten(List<Integer> numbers) {
        return Parser.parseToString(numbers);
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
