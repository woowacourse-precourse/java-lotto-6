package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void start(){
        OutputView.printLottoPurchaseAmountMessage();
        int lottoPurchaseAmount = InputView.getLottoPurchaseAmount();

        List<Lotto> lottos = LottoGenerator.buyLottoTickets(lottoPurchaseAmount);
        OutputView.printUserPurchase(lottos);

        OutputView.printLottoWinningNumberMessage();
        List<Integer> lottoWinningNumbers = InputView.getLottoWinningNumbers();

        OutputView.printLottoBonusNumberMessage();
        int bonusNumber = InputView.getBonusNumber();

        OutputView.printLottoWinningStatisticsMessage();

        //ToDO: 당첨통계 출력하기


    }
}
