package lotto.service;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.exception.DataTypeRangeException;
import lotto.validation.BonusNumberValidator;
import lotto.view.Input;
import lotto.view.Output;

public class BonusNumberService {
    private final Input input;

    public BonusNumberService() {
        this.input = new Input();
    }

    public Bonus fetchValidatedBonus(Lotto winningLotto) {
        while (true) {
            try {
                String readLine = input.getReadLine();
                BonusNumberValidator.validateBonusReadLine(readLine);
                return new Bonus(validateParseNumber(readLine), winningLotto);
            } catch (IllegalArgumentException e) {
                Output.printErrorMessage(e);
            }
        }
    }

    private int validateParseNumber(String readLine) {
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw DataTypeRangeException.dataTypeRangeException;
        }
    }
}
