package lotto.controller;

import lotto.model.*;
import lotto.util.Config;
import lotto.util.MakeStrToListInt;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private Integer lottoTicketNumber;
    public LottoController(){
        this.lottoTicketNumber = 0;
    }
    public void lottoProgram(){
        Purchase purchase = buyLotto();
        LottoBundle lottoBundle = handleLottoBundle();
        WinningNumber winningLotto = handleWinningNumbers();
        handleBonusNumber(winningLotto);
        handleLottoResult(lottoBundle, winningLotto, purchase.getMoney());
    }

    private Purchase buyLotto(){
        while(true){
            try{
                String money = InputView.inputString(ViewMessage.InputUserMoney.getMessage());
                Purchase purchase = new Purchase(money);
                lottoTicketNumber = purchase.getlottoTicketNumber();
                OutputView.outputView("\n" + lottoTicketNumber + ViewMessage.OutputLottoTicketNumber.getMessage());

                return purchase;
            } catch(IllegalArgumentException error){
                OutputView.outputView(ViewMessage.ErrorInvaildMoney.getMessage());
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

    private WinningNumber handleWinningNumbers(){
        while(true){
            try{
                String numbers = InputView.inputString("\n" + ViewMessage.InputWinningNumbers.getMessage());
                return new WinningNumber(MakeStrToListInt.getStrToListInt(numbers));
            } catch(IllegalArgumentException error){
                OutputView.outputView(ViewMessage.ErrorInvaildWinningNumbers.getMessage());
            }
        }
    }

    private void handleBonusNumber(WinningNumber winningLotto){
        while(true){
            try{
                String number = InputView.inputString("\n" + ViewMessage.InputBonusNumber.getMessage());
                winningLotto.setBonusNumber(number);
                break;
            } catch(IllegalArgumentException error){
                OutputView.outputView(ViewMessage.ErrorInvaildBonusNumber.getMessage());
            }
        }
    }

    private void handleLottoResult(LottoBundle lottoBundle, WinningNumber winningLotto, Integer money){
        LottoResult lottoResult = new LottoResult(lottoBundle, winningLotto);
        List<Integer> resultData = lottoResult.getLottoResult();
        OutputView.outputView(ViewMessage.OutputLottoResultThreeMatch.getMessage(resultData.get(Config.threeMatch)));
        OutputView.outputView(ViewMessage.OutputLottoResultFourMatch.getMessage(resultData.get(Config.fourMatch)));
        OutputView.outputView(ViewMessage.OutputLottoResultFiveMatch.getMessage(resultData.get(Config.fiveMatch)));
        OutputView.outputView(ViewMessage.OutputLottoResultBonusMatch.getMessage(resultData.get(Config.bonusMatch)));
        OutputView.outputView(ViewMessage.OutputLottoResultSixMatch.getMessage(resultData.get(Config.sixMatch)));
        Double returnRate = lottoResult.getReturnRate(money);
        OutputView.outputView(ViewMessage.OutputLottoResultReturnRate.getMessage(returnRate));
    }
}
