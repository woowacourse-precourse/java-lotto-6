package lotto.controller.subcontroller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;
import lotto.domain.repository.WinningLottoRepository;
import lotto.util.ExceptionMessage;
import lotto.util.Util;
import lotto.view.InputView;
import lotto.view.OutputView;

public class IssueWinningLottoController implements Controllable {
    private final InputView inputView;
    private final OutputView outputView;

    public IssueWinningLottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        WinningNumber winning = new WinningNumber(inputWinningNumber());
        BonusNumber bonus = new BonusNumber(inputBonusNumber(winning));

        WinningLottoRepository.add(new WinningLotto(winning, bonus));
    }

    private List<Integer> inputWinningNumber() {
        List<Integer> winningNumbers = inputView.inputWinningNumber();
        return winningNumbers;
    }

    private int inputBonusNumber(WinningNumber winning) {
        try {
            int bonusNumber = inputView.inputBonusNumber();
            return bonusNumber;
        } catch (IllegalArgumentException exception) {
            inputView.printExceptionMessage(exception);
            return inputBonusNumber(winning);
        }
    }
}
