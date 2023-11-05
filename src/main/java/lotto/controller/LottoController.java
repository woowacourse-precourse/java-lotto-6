package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

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

        playerLotto(lottoBuy.getQuantity());
    }

    public void playerLotto(int lottoQuantity){
        LottoSet lottoSet = new LottoSet(lottoQuantity);
        OutputView.outputLottoSet(lottoSet);

        inputNumber(lottoSet);
    }

    public void inputNumber(LottoSet lottoSet){
        Lotto lottoWinning = new Lotto(InputView.inputLottoWinning());
        LottoBonus lottoBonus = new LottoBonus(lottoWinning, InputView.inputLottoBonus());

        generateResult(lottoSet, lottoWinning, lottoBonus);
    }

    public void generateResult(LottoSet lottoSet, Lotto lottoWinning, LottoBonus lottoBonus){
        LottoResult lottoResult = new LottoResult(lottoService.generateMap(lottoSet, lottoWinning, lottoBonus));

    }
}
