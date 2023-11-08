package lotto.controller;

import lotto.service.LottoService;
import lotto.service.dto.LottoResultDto;
import lotto.service.dto.PurchaseResultDto;
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

    public void purchaseLotto() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                PurchaseResultDto purchaseResultDto = lottoService.purchaseLotto(input);
                outputView.notifyPurchaseResult(purchaseResultDto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void putWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                lottoService.putWinningNumbers(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void putBonusNumber() {
        while (true) {
            try {
                String input = inputView.readBonusNUmber();
                lottoService.putBonusNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getLottoResult() {
        List<LottoResultDto> resultDtos = lottoService.getLottoResult();
        double rateOfReturn = lottoService.getRateOfReturn();
        outputView.notifyLottoResult(resultDtos, rateOfReturn);
    }
}
