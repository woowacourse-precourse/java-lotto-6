package lotto.controller;

import lotto.entity.Bonus;
import lotto.entity.Cost;
import lotto.entity.Winning;
import lotto.tool.InputTool;
import lotto.view.OutputView;

public class InputController {

    public static Cost inputPurchaseCost() {
        try {
            return new Cost(InputTool.readLineByInputTool());
        } catch (IllegalArgumentException e) {
            OutputView.outputFormatting(e.getMessage().toString());
            return inputPurchaseCost();
        }
    }

    public static Winning inputWinningNumbers() {
        try {
            return new Winning(InputTool.readLineByInputTool());
        } catch (IllegalArgumentException e) {
            OutputView.outputFormatting(e.getMessage().toString());
            return inputWinningNumbers();
        }
    }

    public static Bonus inputBonusNumber() {
        try {
            return new Bonus(InputTool.readLineByInputTool());
        } catch (IllegalArgumentException e) {
            OutputView.outputFormatting(e.getMessage().toString());
            return inputBonusNumber();
        }
    }
}
