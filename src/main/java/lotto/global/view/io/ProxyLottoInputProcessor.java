package lotto.global.view.io;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.WinningNormalNumbers;
import lotto.domain.lotto.WinningNumbers;
import lotto.domain.money.Money;
import lotto.global.view.output.OutputView;

public class ProxyLottoInputProcessor implements InputProcessor{
    private InputProcessor inputProcessor;

    private WinningNumbers winningNumbers;

    public ProxyLottoInputProcessor(lotto.global.view.io.InputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
    }

    @Override
    public Money inputMoney() {
        int retry = 5;
        while (retry-- > 0) {
            try {
                return inputProcessor.inputMoney();
            } catch (Exception e) {
                OutputView.printMessageLine("[ERROR]" + e.getMessage());
            }
        }
        throw new IllegalStateException("[ERROR] 입력 횟수 5번 초과");
    }

    public WinningNumbers inputWinningNumbers() {
        winningNumbers = inputWinningNormalNumbers();
        winningNumbers = inputBonusNumber();

        return winningNumbers;
    }

    @Override
    public WinningNumbers inputWinningNormalNumbers() {
        int retry = 5;
        while (retry-- > 0) {
            try {
                return inputProcessor.inputWinningNormalNumbers();

            } catch (Exception e) {
                OutputView.printMessageLine("[ERROR]" + e.getMessage());
            }
        }
        throw new IllegalStateException("[ERROR] 입력 횟수 5번 초과");
    }

    @Override
    public WinningNumbers inputBonusNumber() {
        int retry = 5;
        while (retry-- > 0) {
            try {
                return inputProcessor.inputBonusNumber();
            } catch (Exception e) {
                OutputView.printMessageLine("[ERROR]" + e.getMessage());
            }
        }
        throw new IllegalStateException("[ERROR] 입력 횟수 5번 초과");
    }

}
