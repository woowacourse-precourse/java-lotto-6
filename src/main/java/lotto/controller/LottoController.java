package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputValue;
import lotto.view.OutputValue;

import java.util.List;

public class LottoController {

    private LottoService lottoService = new LottoService();

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
        lottoCount = InputValue.getPurchasePrice() / 1000;

        OutputValue.changeLine();
    }

    private void purchaseLottoNumberOutputLogic() {

        OutputValue.lottoCountMessage(lottoCount);

        for (Lotto lotto : lottoService.getPurchaseLotto()) {
            OutputValue.purchaseLottoMessage(lotto.getLotto());
        }

        OutputValue.changeLine();
    }

    private void lottoProcess() {

        setWinLottoNumber();

        setBonusNumber();
    }

    private void setWinLottoNumber() {

        OutputValue.winLottoNumberMessage();
        lottoService.setWinLotto(InputValue.getWinLottoNumbers());

        OutputValue.changeLine();
    }

    private void setBonusNumber() {

        OutputValue.bonusNumberMessage();
        lottoService.setBonusNumber(InputValue.getBonusNumber());

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

    }
}
