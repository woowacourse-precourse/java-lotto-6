package lotto;

import java.util.List;
import view.InputView;
import view.OutputView;

public class WinningNumberManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final WinningNumber winningNumber = new WinningNumber();
    private List<Integer> numbers;
    private int bonusNumber;

    public void inputWinningNumber() {
        while (true) {
            try {
                winningNumber.setNumbers(inputView.inputWinningNumber());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                winningNumber.setBonusNumber(inputView.inputBonusNumber());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
