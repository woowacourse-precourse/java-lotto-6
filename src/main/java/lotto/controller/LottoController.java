package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.Lottos;
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
}
