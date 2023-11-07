package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.WinningNumber;
import lotto.model.Purchase;
import lotto.util.MakeStrToListInt;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Integer lottoTicketNumber;

    public LottoController(){
        this.lottoTicketNumber = 0;
    }

    public void lottoProgram(){
        buyLotto();
        LottoBundle lottoBundle = handleLottoBundle();
        WinningNumber winningLotto = setWinningNumbers();
        setBonusNumber(winningLotto);
        System.out.println(winningLotto.getBonusNumber());
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

    private WinningNumber setWinningNumbers(){
        while(true){
            try{
                String numbers = InputView.inputString("\n" + ViewMessage.InputWinningNumbers.getMessage());
                return new WinningNumber(MakeStrToListInt.getStrToListInt(numbers));
            } catch(IllegalArgumentException error){
                OutputView.errorView(ViewMessage.ErrorInvaildWinningNumbers.getMessage());
            }
        }
    }

    private void setBonusNumber(WinningNumber winningLotto){
        while(true){
            try{
                String number = InputView.inputString("\n" + ViewMessage.InputBonusNumber.getMessage());
                winningLotto.setBonusNumber(number);
                break;
            } catch(IllegalArgumentException error){
                OutputView.errorView(ViewMessage.ErrorInvaildBonusNumber.getMessage());
            }
        }
    }
}
