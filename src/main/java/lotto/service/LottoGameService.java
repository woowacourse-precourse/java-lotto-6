package lotto.service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
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
            return inputService.inputMoney();
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

    public Lotto winningNumber() {
        try {
            outputService.winningNumbers();
            List<Integer> numbers = inputService.inputWinningNumbers();
            return new Lotto(numbers);
        }catch (IllegalArgumentException exception) {
            outputService.handleException(exception);
            return winningNumber();
        }
    }
}
