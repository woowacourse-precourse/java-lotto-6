package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.game.Rank;
import lotto.validator.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumbers(numbers);
    }

    public Rank getRank(WinNumber winNumber) {
        int count = getSameNumberCount(winNumber.getNumbers());
        boolean bonus = isBonus(winNumber.getBonusNumber(), count);
        for (Rank rank : Rank.values()) {
            if (rank.getCount() == count && rank.isBonus() == bonus) {
                return rank;
            }
        }
        return Rank.NONE;
    }

    private int getSameNumberCount(Set<Integer> winNumbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBonus(int bonusNumber, int count) {
        boolean bonus = false;
        for (Integer number : numbers) {
            if (number == bonusNumber && count == 5) {
                bonus = true;
            }
        }
        return bonus;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
