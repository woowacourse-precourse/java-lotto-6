package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private Integer lottoTicketNumber;
    public LottoController(){
        this.lottoTicketNumber = 0;
    }

    public void buyLotto(){
        while(true){
            try{
                String money = InputView.inputString(ViewMessage.InputUserPrice.getMessage());
                Purchase purchasePrice = new Purchase(money);
                lottoTicketNumber = purchasePrice.getlottoTicketNumber();
                OutputView.outputView("/n" + lottoTicketNumber + ViewMessage.OutputPurchasesNumber.getMessage());
                break;
            } catch(IllegalArgumentException e){
                OutputView.errorView(ViewMessage.ErrorInvaildPrice.getMessage());
            }
        }
    }

    private void setLottoBundle(){
        LottoBundle lottoBundle = new LottoBundle(lottoTicketNumber);
    }
}
