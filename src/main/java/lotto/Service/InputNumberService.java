package lotto.Service;

import lotto.dto.WinnerAndBonusNumber;
import lotto.model.BonusNumber;
import lotto.model.WinnerNumber;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class InputNumberService {
    private InputView inputView;
    private OutputView outputView;

    public InputNumberService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public WinnerAndBonusNumber input() {
        // 당첨 번호 입력
        WinnerNumber winnerNumber = inputWinnerNumber();
        // 보너스 번호 입력
        BonusNumber bonusNumber = inputBonusNumber(winnerNumber);

        return new WinnerAndBonusNumber(winnerNumber, bonusNumber);
    }

    private WinnerNumber inputWinnerNumber() {
        while (true) {
            try {
                outputView.printWinnerNumber();
                return new WinnerNumber(inputView.inputWinnerNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNumber(WinnerNumber winnerNumber) {
        while (true) {
            try {
                outputView.printBonusNumber();
                return new BonusNumber(winnerNumber, inputView.inputBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
