package lotto.controller;

import java.util.function.Supplier;
import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumberRequest;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningNumberAndBonusNumber;
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
        LottoResult lottoResult = lottos.getLottoResult(winningNumberAndBonusNumber);
        writeLottoResult(lottoResult);
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

    private void writeLottoResult(LottoResult lottoResult) {
        output.writeLottoResultWriteStartMessage();
        output.writeLottoResult(lottoResult);
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
