package lotto.domain.controller;

import lotto.domain.dto.Statistics;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.Money;
import lotto.io.InputPort;
import lotto.io.OutputPort;

import java.util.List;

public record LottoController(InputPort inputPort, OutputPort outputPort) {

    public Money receiveMoney() {
        outputPort.printInputPurchaseAmount();
        while (true) {
            try {
                return new Money(inputPort.receiveMoney());
            } catch (IllegalArgumentException e) {
                outputPort.printErrorMessage(e.getMessage());
            }
        }
    }

    public void showGeneratedLottos(Integer numberOfLottos, List<List<Integer>> generatedLottos) {
        outputPort.printNumberOfLottos(numberOfLottos);
        outputPort.printCreatedLottos(generatedLottos);
    }

    public Lotto receiveWinningNumber() {
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

    public BonusNumber receiveBonusNumber(Lotto winningNumber) {
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

    public void showStatistics(Statistics statistics) {
        outputPort.printStatistics(statistics);
    }
}
