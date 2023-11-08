package lotto.service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;

public class LottoGameService {
    private final InputService inputService;
    private final OutputService outputService;

    public LottoGameService(InputService inputService, OutputService outputService) {
        this.inputService = inputService;
        this.outputService = outputService;
    }

    public Money purchaseAmount() {
        try {
            outputService.purchaseAmount();
            int money = inputService.inputNumber();
            return new Money(money);
        } catch (IllegalArgumentException exception) {
            outputService.handleException(exception);
            return purchaseAmount();
        }
    }

    public Lottos makeLottos(Money money) {
        int ticketCount = money.ticketCount();
        Lottos lottos = new Lottos(ticketCount);
        outputService.lottos(money, lottos);
        return lottos;
    }

    public WinningLotto winningLotto() {
        Lotto winningLotto = winningNumbers();
        int bonusNumber = bonusNumber();
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private Lotto winningNumbers() {
        try {
            outputService.winningNumbers();
            List<Integer> numbers = inputService.inputWinningNumbers();
            return new Lotto(numbers);
        } catch (IllegalArgumentException exception) {
            outputService.handleException(exception);
            return winningNumbers();
        }
    }

    public int bonusNumber() {
        try {
            outputService.bonusNumber();
            return inputService.inputNumber();
        } catch (IllegalArgumentException exception) {
            outputService.handleException(exception);
            return bonusNumber();
        }
    }
}
