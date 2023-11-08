package lotto.controller;

import java.util.function.Supplier;
import lotto.model.WinningNumberAndBonusNumber;
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

        WinningNumberAndBonusNumber winningNumberAndBonusNumber = readWinningNumberAndBonusNumber();
        output.writeEmptyLine();

        writeLottoResult(lottos, winningNumberAndBonusNumber);
    }

    private PurchaseAmountRequest readPurchaseAmount() {
        output.writePurchaseAmountInputMessage();
        return readUntilValidInput(input::readPurchaseAmount);
    }

    private WinningNumberAndBonusNumber readWinningNumberAndBonusNumber() {
        output.writeWinningNumberInputMessage();
        WinningNumberRequest winningNumberRequest =
            readUntilValidInput(input::readWinningNumber);

        output.writeEmptyLine();

        output.writeBonusNumberInputMessage();
        return readUntilValidInput(
            () -> new WinningNumberAndBonusNumber(winningNumberRequest, input.readBonusNumber())
        );
    }

    private void writeLottoResult(Lottos lottos,
        WinningNumberAndBonusNumber winningNumberAndBonusNumber) {
        output.writeLottoResultWriteStartMessage();
    }

    private <T> T readUntilValidInput(Supplier<T> inputSupplier) {
        T input = null;
        boolean isInValidInput = true;

        while (isInValidInput) {
            try {
                input = inputSupplier.get();
                isInValidInput = false;
            } catch (IllegalArgumentException e) {
                output.writeExceptionMessage(e);
            }
        }

        return input;
    }
}
