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

    WinningNumbers winningNumbers;

    public LottoInputProcessor(WinningNumbers winningNumbers) {
        this.winningNumbers  = winningNumbers;
    }

    @Override
    public Money inputMoney() {
        return new Money(InputView.inputInteger());
    }


    @Override
    public WinningNumbers inputWinningNormalNumbers() {
        WinningNormalNumberDto winningNormalNumberDto = new WinningNormalNumberDto(InputView.input());
        winningNumbers.generateWinningNormalNumbers(winningNormalNumberDto.numbers());

        return winningNumbers;
    }

    @Override
    public WinningNumbers inputBonusNumber() {
        BonusNumberDto bonusNumberDto = new BonusNumberDto(InputView.input());

        winningNumbers.generateBonusNumber(bonusNumberDto.number());

        return winningNumbers;
    }
}
