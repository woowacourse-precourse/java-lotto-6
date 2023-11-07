package lotto.controller;

import lotto.service.SetWinningNumService;
import lotto.view.Input;
import lotto.view.Output;
import lotto.vo.WinningNumber;

public class SetWinningNumController {
    WinningNumber winningNumber;

    public SetWinningNumController() {
        setWinningNum();
    }

    private void setWinningNum() {
        Input input = new Input();
        Output output = new Output();

        while (winningNumber == null) {
            output.printWinningNumberPrompt();
            String numbers = input.get();
            try {
                SetWinningNumService service = new SetWinningNumService();
                this.winningNumber = service.generateWinningNumber(numbers);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}