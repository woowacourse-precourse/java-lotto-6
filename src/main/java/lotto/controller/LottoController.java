package lotto.controller;

import lotto.constant.InformationMessage;
import lotto.dto.LottoReceiptDto;
import lotto.dto.LottoResultDto;
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
        runUntilNoException(createDrawBonusNumberRunnable());

        runUntilNoException(createAnnounceLottoResultRunnable());
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

    private Runnable createDrawBonusNumberRunnable() {
        return () -> {
            outputView.print(InformationMessage.GUIDE_INPUT_BONUS_NUMBER.getMessage());
            int bonusNumber = inputView.readIntLine();

            lottoService.drawBonusNumber(bonusNumber);
            outputView.printNewLine();
        };
    }

    private Runnable createAnnounceLottoResultRunnable() {
        return () -> {
            LottoResultDto lottoResult = lottoService.getLottoResult();

            outputView.print(InformationMessage.WINNING_STATISTICS.getMessage());
            outputView.print(InformationMessage.SEPARATOR_LINE.getMessage());
            outputView.printLottoResult(lottoResult);
        };
    }
}
