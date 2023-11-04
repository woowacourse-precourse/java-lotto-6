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
        outputView.printWinnerNumber();
        WinnerNumber winnerNumber = new WinnerNumber(inputView.inputWinnerNumber());

        // 보너스 번호 입력
        outputView.printBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());

        return new WinnerAndBonusNumber(winnerNumber, bonusNumber);
    }
}
