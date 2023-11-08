package lotto.service;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
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
                Output.askBonusNumberEnter();
                String readLine = input.getReadLine();
                BonusNumberValidator.validateBonusReadLine(readLine);
                int parsedNBonus = BonusNumberValidator.validateParseNumber(readLine);
                return new Bonus(parsedNBonus, winningLotto);
            } catch (IllegalArgumentException e) {
                Output.printErrorMessage(e);
            }
        }
    }
}
