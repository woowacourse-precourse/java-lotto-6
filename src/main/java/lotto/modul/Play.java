package lotto.modul;

import lotto.controller.LottoController;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.PurchaseRequest;
import lotto.dto.request.WinningLottoRequest;
import lotto.view.InputView;
import lotto.view.OutView;

public class Play {
    private final InputView inputView = new InputView();
    private final OutView outView = new OutView();
    private final LottoController control = new LottoController();

    public void play(){
        lottoStart();
        var winning = inputView.InputWinningLotto();
        control.receiverWinningLottoInput(new WinningLottoRequest(winning));
        System.out.println();
        var bonus = inputView.InputBonusNumber();
        control.receiverBonusNumberInput(new BonusNumberRequest(bonus));
        outView.displayWinningStatus(control.getLottoWinningStatsResponse());
    }

    public void lottoStart(){
        try{
            var momey = inputView.InputMoney();
            outView.displayPurchase(control.receiverMoneyInput(new PurchaseRequest(momey)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoStart();
        }
    }

}
