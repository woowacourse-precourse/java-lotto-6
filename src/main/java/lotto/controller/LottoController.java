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
    private final LottoBundle lottoBundle;
    public LottoController(){
        this.lottoTicketNumber = 0;
        this.lottoBundle = new LottoBundle();
    }

    public void lottoProgram(){
        buyLotto();
        handleLottoBundle();
    }

    private void buyLotto(){
        while(true){
            try{
                String money = InputView.inputString(ViewMessage.InputUserPrice.getMessage());
                Purchase purchasePrice = new Purchase(money);
                lottoTicketNumber = purchasePrice.getlottoTicketNumber();
                OutputView.outputView("\n" + lottoTicketNumber + ViewMessage.OutputPurchasesNumber.getMessage());
                break;
            } catch(IllegalArgumentException e){
                OutputView.errorView(ViewMessage.ErrorInvaildPrice.getMessage());
            }
        }
    }

    private void handleLottoBundle(){
        lottoBundle.makeLottoBundle(lottoTicketNumber);
        for(int num = 0; num < lottoTicketNumber; num ++){
            OutputView.outputView(lottoBundle.getLottoBundle(num).toString());
        }
    }
}
