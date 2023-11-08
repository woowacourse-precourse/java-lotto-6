package lotto.controller;

import static lotto.constants.Constants.COST_UNIT;

import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.validator.BonusNumberValidator;
import lotto.validator.CostValidator;
import lotto.validator.PrizeNumbersValidator;

import java.util.List;

public class InputController {
    private int amount;
    private int cost;
    private List<Integer> prizeNumbers;
    private int bonusNumber;

    public InputController() {
    }

    public List<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getCost() {
        return cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount() {
        try {
            String cost = InputView.readCost();
            CostValidator costValidator = new CostValidator();
            costValidator.validateCost(cost);
            this.cost = costValidator.cost;
            this.amount = this.cost / COST_UNIT;
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printError(illegalArgumentException.getMessage());
            setAmount();
        }
    }

    public void setPrizeNumbers() {
        try {
            String numbers = InputView.readNumbers();
            PrizeNumbersValidator prizeNumbersValidator = new PrizeNumbersValidator();
            prizeNumbersValidator.validate(numbers);
            prizeNumbers = prizeNumbersValidator.numbers;
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printError(illegalArgumentException.getMessage());
            setPrizeNumbers();
        }
    }

    public void setBonusNumber() {
        try {
            String bonusNumber = InputView.readBonusNumber();
            BonusNumberValidator bonusNumberValidator = new BonusNumberValidator(prizeNumbers);
            bonusNumberValidator.validate(bonusNumber);
            this.bonusNumber = bonusNumberValidator.bonusNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printError(illegalArgumentException.getMessage());
            setBonusNumber();
        }
    }
}
