package lotto.controller;

import java.util.function.Supplier;
import lotto.model.LottoNumbers;
import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumberRequest;
import lotto.model.Lottos;
import lotto.service.LottoMakeService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView input;
    private final OutputView output;
    private final LottoMakeService lottoMakeService;

    public LottoController(InputView input, OutputView output, LottoMakeService lottoMakeService) {
        this.input = input;
        this.output = output;
        this.lottoMakeService = lottoMakeService;
    }

    public void run() {
        Lottos lottos = lottoMakeService.makeRandomLottos(readPurchaseAmount());
        output.writeEmptyLine();
        output.writeLottosInfo(lottos.getLottoInfoResponse());
        output.writeEmptyLine();
        LottoNumbers lottoNumbers = readLottoNumbers();
    }

    private PurchaseAmountRequest readPurchaseAmount() {
        output.writePurchaseAmountInputMessage();
        return readUntilValidInput(input::readPurchaseAmount);
    }

    private LottoNumbers readLottoNumbers() {
        output.writeWinningNumberInputMessage();
        WinningNumberRequest winningNumberRequest =
            readUntilValidInput(input::readWinningNumber);

        output.writeEmptyLine();

        output.writeBonusNumberInputMessage();
        return readUntilValidInput(() ->
            new LottoNumbers(
                winningNumberRequest.winningNumber(),
                input.readBonusNumber().bonusNumber()
            )
        );
    }

    private <T> T readUntilValidInput(Supplier<T> supplier) {
        T input = null;
        boolean isInValidInput = true;

        while (isInValidInput) {
            try {
                input = supplier.get();
                isInValidInput = false;
            } catch (IllegalArgumentException e) {
                output.writeExceptionMessage(e);
            }
        }

        return input;
    }
}
