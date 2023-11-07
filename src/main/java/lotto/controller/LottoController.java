package lotto.controller;

import static lotto.utils.RepeatReader.read;

import lotto.domain.BonusNumber;
import lotto.domain.Customer;
import lotto.domain.LottoAutoIssuePolicy;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResultDto;
import lotto.dto.LottosDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoStore lottoStore;

    public LottoController() {
        this.lottoStore = LottoStore.getInstance();
    }

    public void run() {
        Money money = payMoney();

    }

    private Money payMoney() {
        return new Money(read(InputView::inputMoney));
    }
}
