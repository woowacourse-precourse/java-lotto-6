package lotto.controller;

import lotto.service.SetBonusNumService;
import lotto.view.Input;
import lotto.view.Output;
import lotto.vo.BonusNumber;
import lotto.vo.WinningNumber;
import lotto.vo.WinningResult;

public class SetBonusNumController {
    BonusNumber bonusNumber;

    public SetBonusNumController(WinningNumber winningNumber) {
        setBonusNum(winningNumber);
    }

    private void setBonusNum(WinningNumber winningNumber) {
        Input input = new Input();
        Output output = new Output();

        while (bonusNumber == null) {
            output.printBonusNumberPrompt();
            String number = input.get();
            try {
                SetBonusNumService service = new SetBonusNumService();
                bonusNumber = service.generateBonusNum(number,winningNumber);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber() {
        return this.bonusNumber;
    }
}
