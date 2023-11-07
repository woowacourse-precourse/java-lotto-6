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
        WinningNumber winning = inputWinningNumber();
        BonusNumber bonus = inputBonusNumber(winning);

        WinningLottoRepository.add(new WinningLotto(winning, bonus));
    }

    private WinningNumber inputWinningNumber() {
        try {
            List<Integer> winningNumbers = inputView.inputWinningNumber();
            return new WinningNumber(winningNumbers);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return inputWinningNumber();
        }
    }

    private BonusNumber inputBonusNumber(WinningNumber winning) {
        try {
            int bonusNumber = inputView.inputBonusNumber();
            validateDuplicateWithWinningNumber(winning.getNumbers(), bonusNumber);
            return new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return inputBonusNumber(winning);
        }
    }

    private void validateDuplicateWithWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        for (Integer winning : winningNumbers) {
            if (Util.isEqual(bonusNumber, winning)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
            }
        }
    }
}
