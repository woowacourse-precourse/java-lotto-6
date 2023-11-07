package lotto.domain;

import lotto.function.InputFunction;
import lotto.function.PrintMessageFunction;
import lotto.function.ValidationFunction;

import java.util.ArrayList;
import java.util.List;

public class GetWinningNumbers {

    PrintMessageFunction printMessageFunction = new PrintMessageFunction();
    InputFunction inputFunction = new InputFunction();
    ValidationFunction validationFunction = new ValidationFunction();

    private List<Integer> winningNums;

    private Integer bonusNum;

    private List<Integer> getInputWinningNumbers() {
        printMessageFunction.printWinningNumbers();
        String strWinningNumbers = inputFunction.getUserInput();
        String[] splitWinningNumbers = strWinningNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        validationFunction.validateWinningNumberDuplicate(splitWinningNumbers);
        validationFunction.validateWinningNumberRange(splitWinningNumbers);
        validationFunction.validateWinningNumberSize(splitWinningNumbers);

        for (int i = 0; i < splitWinningNumbers.length; i++) {
            int winNum = Integer.parseInt(splitWinningNumbers[i]);
            winningNumbers.add(winNum);
        }

        return winningNumbers;
    }

    private int getInputBonusNumber() {
        printMessageFunction.printBonusNumber();
        int bonusNum = Integer.parseInt(inputFunction.getUserInput());
        validationFunction.validateBonusNumber(bonusNum);

        return bonusNum;
    }

    public GetWinningNumbers getWinningNumbersInfo() {
        this.winningNums = getInputWinningNumbers();
        this.bonusNum = getInputBonusNumber();

        return this;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }
}
