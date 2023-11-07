package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public void play() {
        try {
            buy();
        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void buy(){
        LottoBuy lottoBuy = new LottoBuy(InputView.inputBuyMoney());
        OutputView.outputLottoNum(lottoBuy.getQuantity());

        playerLotto(lottoBuy.getQuantity(), lottoBuy.getMoney());
    }

    public void playerLotto(int lottoQuantity, Integer lottoBuyMoney){
        LottoSet lottoSet = new LottoSet(lottoQuantity);
        OutputView.outputLottoSet(lottoSet);

        inputNumber(lottoSet, lottoBuyMoney);
    }

    public void inputNumber(LottoSet lottoSet, Integer lottoBuyMoney){
        Lotto lottoWinning = new Lotto(InputView.inputLottoWinning());
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, InputView.inputLottoBonus());

        generateResult(lottoSet, lottoWinning, lottoBonus, lottoBuyMoney);
    }

    public void generateResult(LottoSet lottoSet, Lotto lottoWinning, LottoBonus lottoBonus, Integer lottoBuyMoney) {
        Map<LottoRank, Integer> result = LottoResult.calculateLottoResult(lottoSet, lottoWinning, lottoBonus);
        LottoResult lottoResult = new LottoResult(result);

        Integer earnMoney = OutputView.outputLottoResult(lottoResult);
        OutputView.outputLottoProfit(earnMoney, lottoBuyMoney);
    }
}
