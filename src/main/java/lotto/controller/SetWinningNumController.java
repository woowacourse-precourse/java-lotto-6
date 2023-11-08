package lotto.controller;

import lotto.service.SetWinningNumService;
import lotto.view.Input;
import lotto.view.Output;
import lotto.vo.WinningNumber;

public class SetWinningNumController {
    WinningNumber winningNumber;
    SetWinningNumService service;

    public SetWinningNumController(SetWinningNumService service) {
        this.service = service;
        setWinningNum();
    }

    private void setWinningNum() {
        Input input = new Input();
        Output output = new Output();

        while (winningNumber == null) {
            output.printWinningNumberPrompt();
            String numbers = input.get();
            try {
                this.winningNumber = service.generateWinningNumber(numbers);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }
}