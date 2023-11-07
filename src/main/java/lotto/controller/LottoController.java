package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoController {

    public void lottoStart() {
        int userMoney = InputView.userHaveMoney();
        Lottos lottos = new Lottos(userMoney);
        OutPutView outPutView = new OutPutView();

        System.out.println();

        outPutView.outPutViewLottos(lottos, userMoney); //개를 구매했습니다.

        LottoResult lottoResult = new LottoResult();

        System.out.println();

        lottoResult.calculateWinningResult(lottos, InputView.inputWinningNumbers(), InputView.inputBonusNumber());

        outPutView.outPutViewWinningStatistics(lottoResult);
        System.out.println("총 수익률은 " + lottoResult.calculateProfitRate(userMoney) + "%입니다.");
    }


}
