package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInput {
    private int amount;
    private List<Integer> prizeNumbers;
    private int bonusNumber;

    public UserInput() {
    }

    public int getAmount() {
        return amount;
    }

    public List<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setAmount() {
        try {
            String cost = Console.readLine();
            CostValidator costValidator = new CostValidator();
            costValidator.validateCost(cost);
            amount = costValidator.cost / 1000;
        } catch (IllegalArgumentException illegalArgumentException) {
            setAmount();
        }
    }

    public void setPrizeNumbers() {
        try {
            String numbers = Console.readLine();
            PrizeNumbersValidator prizeNumbersValidator = new PrizeNumbersValidator();
            prizeNumbersValidator.validate(numbers);
            prizeNumbers = prizeNumbersValidator.numbers;
        } catch (IllegalArgumentException illegalArgumentException) {
            setPrizeNumbers();
        }
    }

    public void setBonusNumber() {
        try {
            String bonusNumber = Console.readLine();
            BonusNumberValidator bonusNumberValidator = new BonusNumberValidator(prizeNumbers);
            bonusNumberValidator.validate(bonusNumber);
            this.bonusNumber = bonusNumberValidator.bonusNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            setBonusNumber();
        }
    }
}
