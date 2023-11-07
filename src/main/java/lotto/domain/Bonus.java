package lotto.domain;

import java.util.List;
import lotto.util.Convertor;
import lotto.util.Validator;

public class Bonus {

    private final int number;

    public Bonus(String inputNumber, List<Integer> winningNumbers) {
        int number = Convertor.getInstance().convertToInt(inputNumber);
        Validator.getInstance().validateBonusNumber(number, winningNumbers);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
