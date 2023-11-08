package lotto.controller;

import lotto.entity.Bonus;
import lotto.entity.Cost;
import lotto.entity.Winning;
import lotto.tool.InputTool;
import lotto.view.OutputView;

public class InputController {

    public static Cost inputPurchaseCost() {
        try {
            String inputPurchaseCost = InputTool.readLineByInputTool();
            return new Cost(inputPurchaseCost);
        } catch (OutOfMemoryError e) {
            OutputView.outputFormatting("너무 많음 금액을 입력하였습니다");
            return inputPurchaseCost();
        } catch (IllegalArgumentException e) {
            OutputView.outputFormatting(e.getMessage().toString());
            return inputPurchaseCost();
        }
    }

    public static Winning inputWinningNumbers() {
        try {
            String inputWinningNumbers = InputTool.readLineByInputTool();
            return new Winning(inputWinningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.outputFormatting(e.getMessage().toString());
            return inputWinningNumbers();
        }
    }

    public static Bonus inputBonusNumber(Winning winning) {
        try {
            String inputBonusNumber = InputTool.readLineByInputTool();
            return new Bonus(inputBonusNumber, winning);
        } catch (IllegalArgumentException e) {
            OutputView.outputFormatting(e.getMessage().toString());
            return inputBonusNumber(winning);
        }
    }
}
