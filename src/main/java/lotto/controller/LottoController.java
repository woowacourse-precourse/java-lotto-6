package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutPutView;

import static lotto.view.InputView.inputMoney;

public class LottoController {

    public void lottoStart() {
        int userMoney = inputMoney();

        Lottos lottos = new Lottos(userMoney);
        OutPutView outPutView = new OutPutView();

        outPutView.outPutViewLottos(lottos, userMoney);

        LottoResult lottoResult = new LottoResult();

        lottoResult.calculateWinningResult(lottos, InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        outPutView.outPutViewWinningStatistics(lottoResult);

        System.out.print("총 수익률은 " + lottoResult.calculateProfitRate(userMoney) + "%입니다.");
    }
}
