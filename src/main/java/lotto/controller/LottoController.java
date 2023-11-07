package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.service.LottoService;
import lotto.service.PriceService;
import lotto.view.InputValue;
import lotto.view.OutputValue;

import java.util.List;

public class LottoController {

    private LottoService lottoService = new LottoService();
    private PriceService priceService = new PriceService();

    private int lottoCount;

    public LottoController() {
        lottoInit();
        lottoProcess();
        lottoEnd();
    }

    private void lottoInit() {

        purchasePriceInputLogic();

        lottoService.repeatPurchase(lottoCount);

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

        OutputValue.lottoCountMessage(lottoCount);

        for (Lotto lotto : lottoService.getPurchaseLotto()) {
            OutputValue.purchaseLottoMessage(lotto.getLotto());
        }

        OutputValue.changeLine();
    }

    private void lottoProcess() {

        OutputValue.winLottoNumberMessage();
        List<Integer> winLotto = InputValue.getWinLottoNumbers();
        lottoService.setWinLotto(winLotto);

        OutputValue.changeLine();

        OutputValue.bonusNumberMessage();
        lottoService.setBonusNumber(InputValue.getBonusNumber(winLotto));

        OutputValue.changeLine();
    }

    private void lottoEnd() {

        OutputValue.winStatisticsMessage();

        lottoService.winStatistics();
        List<Integer> placeCounts = lottoService.getWinStatistics();

        OutputValue.fifthPlaceMessage(placeCounts.get(4));
        OutputValue.fourthPlaceMessage(placeCounts.get(3));
        OutputValue.thirdPlaceMessage(placeCounts.get(2));
        OutputValue.secondPlaceMessage(placeCounts.get(1));
        OutputValue.firstPlaceMessage(placeCounts.get(0));

        OutputValue.revenueMessage(lottoService.getRevenue(lottoCount * 1000));
    }
}
