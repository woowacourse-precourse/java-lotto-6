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

}
