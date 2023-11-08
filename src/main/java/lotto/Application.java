package lotto;

import lotto.controller.LottoController;
import lotto.handler.UserHandler;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();

        int amount = UserHandler.getAmountFromUser();
        int lottoCount = UserHandler.getLottoCountFromUser(amount);

        lottoController.buyLottos(lottoCount);

        List<String> winningNumbers = UserHandler.getWinningNumberFromUser();
        Lotto winningLotto = lottoController.createWinningLotto(winningNumbers);
        int bonusNumber = UserHandler.getAndValidateBonusNumber(winningNumbers);

        Map<Rank, Integer> result = lottoController.calculateResult(lottoController.lottos, winningLotto, bonusNumber);

        ResultView.printResult(result);

        long totalPrize = lottoController.calculateTotalPrize(result);
        double returnRate = lottoController.calculateReturnRate(totalPrize, amount);

        ResultView.printReturnRate(returnRate);
    }
}

