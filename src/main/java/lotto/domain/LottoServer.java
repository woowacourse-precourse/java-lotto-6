package lotto.domain;

import lotto.domain.dto.Purchase;
import lotto.domain.dto.Statistics;
import lotto.io.InputPort;
import lotto.io.OutputPort;

import java.util.List;

public final class LottoServer {

    private final InputPort inputPort;
    private final OutputPort outputPort;
    private final LottoGenerator generator;

    public LottoServer(InputPort inputPort, OutputPort outputPort, LottoGenerator generator) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
        this.generator = generator;
    }

    public void run() {
        Money money = receiveMoney();
        Purchase purchase = new LottoStore(new LottoFactory(generator)).sellLottos(money);
        showGeneratedLottos(purchase.numberOfLottos(), purchase.lottos().getLottos());
        Lottos generatedLottos = purchase.lottos();
        Lotto winningNumber = receiveWinningNumber();
        BonusNumber bonusNumber = receiveBonusNumber(winningNumber);
        Statistics statistics = new StatisticsCalculator().calculate(generatedLottos, winningNumber, bonusNumber, money);
        outputPort.printStatistics(statistics);
    }

    private Money receiveMoney() {
        outputPort.printInputPurchaseAmount();
        while (true) {
            try {
                return new Money(inputPort.receiveMoney());
            } catch (IllegalArgumentException e) {
                outputPort.printErrorMessage(e.getMessage());
            }
        }
    }

    private void showGeneratedLottos(Integer numberOfLottos, List<List<Integer>> generatedLottos) {
        outputPort.printNumberOfLottos(numberOfLottos);
        outputPort.printCreatedLottos(generatedLottos);
    }

    private Lotto receiveWinningNumber() {
        outputPort.printInputWinningNumbers();
        while (true) {
            try {
                List<Integer> winningNumbers = inputPort.receiveLottos();
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputPort.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber receiveBonusNumber(Lotto winningNumber) {
        outputPort.printInputBonusNumber();
        while (true) {
            try {
                int bonusNumber = inputPort.receiveBonus();
                return new BonusNumber(bonusNumber, winningNumber);
            } catch (IllegalArgumentException e) {
                outputPort.printErrorMessage(e.getMessage());
            }
        }
    }
}
