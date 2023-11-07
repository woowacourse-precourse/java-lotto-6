package lotto.global.view.io;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.WinningNormalNumbers;
import lotto.domain.lotto.WinningNumbers;
import lotto.domain.lotto.dto.BonusNumberDto;
import lotto.domain.lotto.dto.WinningNormalNumberDto;
import lotto.domain.money.Money;
import lotto.global.constant.message.GameMessage;
import lotto.global.view.input.InputView;
import lotto.global.view.output.OutputView;

public class LottoInputProcessor implements InputProcessor {

    Money money;

    WinningNumbers winningNumbers;

    public LottoInputProcessor(WinningNumbers winningNumbers) {
        this.winningNumbers  = winningNumbers;
    }

    @Override
    public Money inputMoney() {
        OutputView.printMessageLine(GameMessage.INPUT_MONEY.getMessage());
        long inputMoney = InputView.inputInteger();
        money = new Money(inputMoney);
        return new Money(inputMoney);
    }


    @Override
    public WinningNumbers inputWinningNumbers() {
        inputWinningNormalNumbers();
        inputBonusNumber();

        return winningNumbers;
    }

    @Override
    public WinningNumbers inputWinningNormalNumbers() {
        OutputView.printMessageLine(GameMessage.INPUT_WINNING_NUMBERS.getMessage());

        WinningNormalNumberDto winningNormalNumberDto = new WinningNormalNumberDto(InputView.input());
        winningNumbers.generateWinningNormalNumbers(winningNormalNumberDto.numbers());

        return winningNumbers;
    }

    @Override
    public WinningNumbers inputBonusNumber() {
        OutputView.printMessageLine(GameMessage.INPUT_BONUS_NUMBERS.getMessage());
        BonusNumberDto bonusNumberDto = new BonusNumberDto(InputView.input());

        winningNumbers.generateBonusNumber(bonusNumberDto.number());

        return winningNumbers;
    }
}
