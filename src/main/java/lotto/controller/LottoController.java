package lotto.controller;

import lotto.Service.LottoService;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    LottoService lottoService = new LottoService();
    public void play() {
        try {
            buy();
        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void buy(){
        Integer buyMoney = InputView.inputBuyMoney();
        LottoBuy lottoBuy = new LottoBuy(buyMoney);
        OutputView.outputLottoNum(lottoBuy.getQuantity());

        generateLotto(lottoNum);
    }

    public void generateLotto(int lottoNum){
        LottoSet lottoSet = new LottoSet(lottoService.generateLottoSet(lottoNum));
        OutputView.outputLottoSet(lottoSet);

        inputNumber(lottoSet);
    }

    public void inputNumber(LottoSet lottoSet){
        LottoWinning lottoWinning = new LottoWinning(InputView.inputLottoWinning());
        LottoBonus lottoBonus = new LottoBonus(lottoWinning.getNumbers(), InputView.inputLottoBonus());

        generateResult(lottoSet, lottoWinning, lottoBonus);
    }

    public void generateResult(LottoSet lottoSet, LottoWinning lottoWinning, LottoBonus lottoBonus){
        LottoResult lottoResult = new LottoResult(lottoService.generateMap(lottoSet, lottoWinning, lottoBonus));

    }
}
