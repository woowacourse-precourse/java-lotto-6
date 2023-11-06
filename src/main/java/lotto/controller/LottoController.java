package lotto.controller;

import lotto.constant.InformationMessage;
import lotto.dto.LottoReceiptDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

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
            outputView.printInformationMessage(InformationMessage.GUIDE_INPUT_PURCHASE_AMOUNT);
            long amount = inputView.readIntLine();
            LottoReceiptDto lottoReceipt = lottoService.getLottoReceipt(amount);
            outputView.printLottoReceipt(lottoReceipt);
        };
    }
}
