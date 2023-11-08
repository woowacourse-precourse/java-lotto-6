package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.ProfitCalculator;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.StringUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void run() {
        LottoMoney lottoMoney = getLottoMoney();

        Lottos newlottos = new Lottos(lottoMoney.buyLottos());
        OutputView.printLottoCountMessage(newlottos.getLottoCount());
        OutputView.printLottos(newlottos);

        Lotto lotto = getWinningLotto();
        int bonusNumber = getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult lottoResult = LottoService.getLottoResult(newlottos, winningLotto);
        OutputView.printStatisticsMessage(lottoResult);

        String profit = ProfitCalculator.calculate(newlottos.getPriceSum(winningLotto),
            newlottos.getLottoCount());
        OutputView.printProfitMessage(profit);
    }

    public static LottoMoney getLottoMoney() {
        try {
            OutputView.printLottoPurchaseMoneyMessage();
            String input = InputView.readLine();
            OutputView.printEmptyLine();
            return new LottoMoney(input);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            return getLottoMoney();
        }
    }

    public static Lotto getWinningLotto() {
        try {
            OutputView.printWinningLottoMessage();
            String input = InputView.readLine();
            OutputView.printEmptyLine();
            List<Integer> numbers = StringUtils.splitStringToLottoNumbers(input);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            return getWinningLotto();
        }
    }

    public static int getBonusNumber() {
        try {
            OutputView.printBonusNumberMessage();
            int input = InputView.readInteger();
            OutputView.printEmptyLine();
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            return getBonusNumber();
        }
    }
}
