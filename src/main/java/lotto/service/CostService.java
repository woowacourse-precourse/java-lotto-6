package lotto.service;

import lotto.domain.Cost;
import lotto.validation.CostValidator;
import lotto.view.Input;
import lotto.view.Output;

public class CostService {

    private final Input input;

    public CostService() {
        this.input = new Input();
    }

    public Cost fetchValidatedCost() {
        while (true) {
            try {
                Output.askCostEnter();
                String readLine = input.getReadLine();
                CostValidator.validateCostReadLine(readLine);
                int parsedCost = CostValidator.validateParseNumber(readLine);
                return new Cost(parsedCost);
            } catch (IllegalArgumentException e) {
                Output.printErrorMessage(e);
            }
        }
    }
}
