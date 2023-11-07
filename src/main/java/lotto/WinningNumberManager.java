package lotto;

import view.InputView;

public class WinningNumberManager {
    private final InputView inputView = new InputView();
    private final WinningNumber winningNumber = new WinningNumber();
    private final LottoMachine LottoMachineFromSeller = LottoSeller.lottoMachine;

    public void setWinningNumberToLottoMachine() {
        inputWinningNumber();
        inputBonusNumber();
        LottoMachineFromSeller.setWinningNumberToCalculator(winningNumber);
    }

    private void inputWinningNumber() {
        while (true) {
            try {
                winningNumber.setNumbers(inputView.inputWinningNumber());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
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
