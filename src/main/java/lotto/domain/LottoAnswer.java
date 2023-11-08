package lotto.domain;


import lotto.error.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoAnswer extends Lotto {
    private BonusNumber bonusNumber;
    private final List<Integer> numbers = getNumbers();
    public LottoAnswer(String input) {
        parseInteger(input);
        validate(numbers);
    }

    public LottoAnswer(String input, int bonusNumber) {
        parseInteger(input);
        validate(getNumbers());
        isUniqueBonus(numbers, bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void parseInteger(String input) {
        String[] parts = input.split(",");

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                numbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT);
            }
        }
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public boolean hasBonusNumber() {
        return bonusNumber != null;
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        isUniqueBonus(numbers, bonusNumber.getNumber());
        this.bonusNumber = bonusNumber;
    }

    private void isUniqueBonus(List<Integer> numbers, int bonusNumber) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBERS);
        }
    }
}
