package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.Purchase;
import lotto.util.MakeRandomNumbers;
import lotto.util.MakeStrToListInt;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private Integer lottoTicketNumber;

    public LottoController(){
        this.lottoTicketNumber = 0;
    }

    public void lottoProgram(){
        buyLotto();
        LottoBundle lottoBundle = handleLottoBundle();
        Lotto winningLotto = setWinningNumbers();
    }

    private void buyLotto(){
        while(true){
            try{
                String money = InputView.inputString(ViewMessage.InputUserMoney.getMessage());
                Purchase purchasePrice = new Purchase(money);
                lottoTicketNumber = purchasePrice.getlottoTicketNumber();
                OutputView.outputView("\n" + lottoTicketNumber + ViewMessage.OutputLottoTicketNumber.getMessage());
                break;
            } catch(IllegalArgumentException error){
                OutputView.errorView(ViewMessage.ErrorInvaildMoney.getMessage());
            }
        }
    }

    private LottoBundle handleLottoBundle(){
        LottoBundle lottoBundle = new LottoBundle();
        lottoBundle.makeLottoBundle(lottoTicketNumber);
        for(int num = 0; num < lottoTicketNumber; num ++){
            OutputView.outputView(lottoBundle.getLottoBundle(num).toString());
        }
        return lottoBundle;
    }

    private Lotto setWinningNumbers(){
        while(true){
            try{
                String numbers = InputView.inputString(ViewMessage.InputWinningNumbers.getMessage());
                return new Lotto(MakeStrToListInt.getStrToListInt(numbers));
            } catch(IllegalArgumentException error){
                OutputView.errorView(ViewMessage.ErrorInvaildWinningNumbers.getMessage());
            }
        }
    }
}
