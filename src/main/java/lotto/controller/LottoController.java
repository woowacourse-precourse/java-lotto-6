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
        Money money = read(this::payMoney);
        Lottos lottos = read(() -> buyLotto(money));
        Customer customer = new Customer(money, lottos);

        WinningNumbers winningNumbers = read(this::drawWinningNumbers);
        BonusNumber bonusNumber = read(() -> drawBonusNumber(winningNumbers));

        showLottoResult(customer, winningNumbers, bonusNumber);
    }

    private Money payMoney() {
        return new Money(InputView.inputMoney());
    }

    private Lottos buyLotto(Money money) {
        Lottos lottos = lottoStore.issue(money, new LottoAutoIssuePolicy());
        OutputView.printQuantity(money.getBuyLottoQuantity());
        OutputView.printLottos(LottosDto.from(lottos));
        return lottos;
    }

    private WinningNumbers drawWinningNumbers() {
        return lottoStore.drawWinningNumbers(InputView.inputWinningNumbers());
    }

    private BonusNumber drawBonusNumber(WinningNumbers winningNumbers) {
        return lottoStore.drawBonusNumber(InputView.inputBonusNumber(), winningNumbers);
    }

    private void showLottoResult(Customer customer, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        LottoResult result = customer.getLottoResult(winningNumbers, bonusNumber);
        OutputView.printLottoResult(LottoResultDto.from(result));
        OutputView.printTotalReturn(result.calculateTotalReturn(customer.getMoney()));
    }
}
