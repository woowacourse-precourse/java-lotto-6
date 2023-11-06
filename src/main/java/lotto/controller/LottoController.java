package lotto.controller;

import lotto.constant.InformationMessage;
import lotto.dto.LottoReceiptDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        runUntilNoException(createPurchaseLottoRunnable());
        runUntilNoException(createDrawLottoWithoutBonusNumberRunnable());
    }

    private void runUntilNoException(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException clientException)  {
                outputView.printErrorMessage(clientException);
            }
        }
    }

    private Runnable createPurchaseLottoRunnable() {
        return () -> {
            outputView.print(InformationMessage.GUIDE_INPUT_PURCHASE_AMOUNT.getMessage());
            long amount = inputView.readLongLine();
            outputView.printNewLine();
            LottoReceiptDto lottoReceipt = lottoService.getLottoReceipt(amount);
            outputView.printLottoReceipt(lottoReceipt);
            outputView.printNewLine();
        };
    }

    private Runnable createDrawLottoWithoutBonusNumberRunnable() {
        return () -> {
            outputView.print(InformationMessage.GUIDE_INPUT_WINNING_LOTTO_NUMBER.getMessage());
            List<Integer> numbers = inputView.readMultipleIntLine();
            lottoService.drawLottoWithoutBonusNumber(numbers);
            outputView.printNewLine();
        };
    }
}
