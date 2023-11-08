package lotto.controller;

import lotto.service.SetBonusNumService;
import lotto.view.Input;
import lotto.view.Output;
import lotto.vo.BonusNumber;

import lotto.vo.WinningNumber;

public class SetBonusNumController {
    BonusNumber bonusNumber;
    SetBonusNumService service;

    public SetBonusNumController(WinningNumber winningNumber, SetBonusNumService service) {
        this.service = service;
        setBonusNum(winningNumber);
    }

    private void setBonusNum(WinningNumber winningNumber) {
        Input input = new Input();
        Output output = new Output();

        while (bonusNumber == null) {
            output.printBonusNumberPrompt();
            String number = input.get();
            try {
                bonusNumber = service.generateBonusNum(number, winningNumber);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
