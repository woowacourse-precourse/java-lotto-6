package lotto.io;

import static lotto.utils.string.StringUtils.convertStringListToIntegerList;

import java.util.List;
import lotto.io.input.InputView;
import lotto.io.output.OutputView;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.money.UserBudget;

public class IOManager {
    private final InputView inputView;
    private final OutputView outputView;

    public IOManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public UserBudget getUserBudget() {
        boolean maintainLoopFlag = true;
        UserBudget userBudget = null;

        while (maintainLoopFlag) {
            maintainLoopFlag = false;
            outputView.printGetLottoMoney();
            int parsedBudget;
            try {
                parsedBudget = Integer.parseInt(inputView.getLottoMoney());
                userBudget = UserBudget.of(parsedBudget);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
                maintainLoopFlag = true;
            }
        }

        return userBudget;
    }

    public Lotto getWinningNumbers() {
        boolean maintainLoopFlag = true;
        Lotto winningNumbers = null;

        while (maintainLoopFlag) {
            maintainLoopFlag = false;
            outputView.printGetWinningNumbers();
            try {
                List<String> parsedWinningNumbers = inputView.getWinningNumbers();
                winningNumbers = new Lotto(convertStringListToIntegerList(parsedWinningNumbers));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
                maintainLoopFlag = true;
            }
        }

        return winningNumbers;
    }

    public BonusNumber getBonusNumber(Lotto winningNumbers) {
        boolean maintainLoopFlag = true;
        BonusNumber bonusNumber = null;

        while (maintainLoopFlag) {
            maintainLoopFlag = false;
            outputView.printGetBonusNumber();
            try {
                int parsedBonusNumber = Integer.parseInt(inputView.getBonusNumber());
                bonusNumber = BonusNumber.of(parsedBonusNumber);
                bonusNumber.validateBonusNumberDuplicated(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
                maintainLoopFlag = true;
            }
        }

        return bonusNumber;
    }
}
