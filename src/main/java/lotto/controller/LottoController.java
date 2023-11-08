package lotto.controller;

import lotto.domain.LottoWinningNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputBonusNumberView;
import lotto.view.InputBuyLottoView;
import lotto.view.InputLottoWinningNumbersView;

import java.util.List;

public class LottoController {


    private Money getLottoMoney(){
        InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
        int money = inputBuyLottoView.insertCoin();
        return new Money(money);
    }

    private Lottos getLottos(Money money){
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoList(money.getTicket()));
    }

    private LottoWinningNumber getLottoWinningNumber(){
        InputLottoWinningNumbersView inputLottoWinningNumbersView = new InputLottoWinningNumbersView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> lottoWinningNumbers = inputLottoWinningNumbersView.inputLottoWinningNumbers();
        Integer bonusNumber = inputBonusNumberView.inputBonusNumber();

        return new LottoWinningNumber(lottoWinningNumbers, bonusNumber);
    }

    private void calcLottoResult(PrizeResult prizeResult, LottoWinningNumber lottoWinningNumber, Lottos lottos){
        prizeResult.calcPrizeResult(lottoWinningNumber, lottos);
    }
}
