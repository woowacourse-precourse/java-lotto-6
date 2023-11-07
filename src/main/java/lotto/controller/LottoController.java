package lotto.controller;

import lotto.domain.BonusNum;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.CalculateRate;
import lotto.util.GenerateTicket;
import lotto.util.MakeLotto;
import lotto.domain.LottoResult;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private InputController inputController = new InputController();
    private MakeLotto makeLotto = new MakeLotto();

    public LottoController(){
        Money money = setMoney();
        int lottoTicket = GenerateTicket.getLottoTickets(money.getMoney());
        List<Lotto> lottoList = makeLotto.makeLottoList(lottoTicket);
        List<Integer> winningNum = setWinningNum();
        BonusNum bonusNum = setBonusNum();
        LottoResult lottoResult = new LottoResult(lottoList, winningNum, bonusNum.getBonusNum());
        double totalRate = CalculateRate.getTotalRate(money.getMoney(), lottoResult.getTotalReward());
        printResult(lottoResult, totalRate);
    }

    public Money setMoney(){
        OutputView.inputBuyMessage();
        return inputController.inputMoney();
    }

    public List<Integer> setWinningNum(){
        OutputView.printBlank();
        OutputView.inputWinningNumMessage();
        return inputController.inputWinningNum();
    }

    public BonusNum setBonusNum(){
        OutputView.printBlank();
        OutputView.inputBonusNumMessage();
        return inputController.inputBonusNum();
    }

    public void printResult(LottoResult lottoResult, double totalReward){
        OutputView.printBlank();
        OutputView.printResultBar();
        OutputView.printResult(lottoResult.getLottoResult());
        OutputView.printTotalRate(totalReward);
    }
}
