package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningCriteria;
import lotto.domain.WinningDetails;
import lotto.service.LottoService;
import lotto.service.PriceService;
import lotto.view.InputValue;
import lotto.view.OutputValue;


import java.util.Collections;
import java.util.List;

import static lotto.domain.WinningCriteria.SECOND_PRIZE;


public class LottoController {

    private LottoService lottoService = new LottoService();
    private PriceService priceService = new PriceService();

    public LottoController() {
        lottoInit();
        lottoProcess();
        lottoEnd();
    }

    private void lottoInit() {

        purchasePriceInputLogic();

        purchaseLottoNumberOutputLogic();

    }

    private void purchasePriceInputLogic() {

        OutputValue.purchaseMessage();

        try {
            priceService.setPurchasePrice(InputValue.getPurchasePrice());
            OutputValue.changeLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            OutputValue.changeLine();
            purchasePriceInputLogic();
        }

    }

    private void purchaseLottoNumberOutputLogic() {

        int lottoPurchaseQuantity = priceService.getLottoPurchaseQuantity();
        lottoService.repeatPurchase(lottoPurchaseQuantity);

        OutputValue.lottoCountMessage(lottoPurchaseQuantity);
        for (Lotto lotto : lottoService.getPurchaseLottos()) {
            OutputValue.purchaseLottoMessage(lotto.getLotto());
        }

        OutputValue.changeLine();
    }

    private void lottoProcess() {
        winningLottoNumbersInputLogic();
        bonusNumberInputLogic();
    }

    private void winningLottoNumbersInputLogic() {

        OutputValue.winningLottoNumbersMessage();

        try {
            List<Integer> winningLottoNumbers = InputValue.getWinningLottoNumbers();
            Collections.sort(winningLottoNumbers);
            lottoService.setWinningLottoNumbers(winningLottoNumbers);
            OutputValue.changeLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            OutputValue.changeLine();
            winningLottoNumbersInputLogic();
        }
    }

    private void bonusNumberInputLogic() {

        OutputValue.bonusNumberMessage();

        try {
            lottoService.setBonusNumber(InputValue.getBonusNumber());
            OutputValue.changeLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            OutputValue.changeLine();
            bonusNumberInputLogic();
        }
    }


    private void lottoEnd() {
        WinningDetails winningDetails = lottoService.calculateWinningDetails();
        priceService.calculateWinningPrice(winningDetails);

        OutputValue.winStatisticsMessage();

        for (WinningCriteria winningCriteria : WinningCriteria.values()) {
            if (winningCriteria.getRank() == SECOND_PRIZE.getRank()) {
                OutputValue.winningLottoSecondPrizeMessage(winningCriteria.getNumberMatch(), winningCriteria.getOutputPrice(),
                        winningDetails.getWinningCount(winningCriteria.getRank()));
                continue;
            }
            OutputValue.winningLottoResultMessage(winningCriteria.getNumberMatch(), winningCriteria.getOutputPrice(),
                    winningDetails.getWinningCount(winningCriteria.getRank()));
        }

        OutputValue.revenueMessage(priceService.getEarningRate());
    }

    //private void
}

