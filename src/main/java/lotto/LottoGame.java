package lotto;

import lotto.domain.BuyLotto;
import lotto.domain.GetWinningNumbers;
import lotto.domain.LottoResult;
import lotto.function.PrintMessageFunction;

public class LottoGame {
    private final PrintMessageFunction printMessageFunction = new PrintMessageFunction();
    private final BuyLotto buyLotto = new BuyLotto();
    private final GetWinningNumbers getWinningNumbers = new GetWinningNumbers();

    public void play() {
        printMessageFunction.printMoneyInput();
        try {
            BuyLotto buyLottoInfo = buyLotto.getBuyInfo();
            GetWinningNumbers winningNumbersInfo = getWinningNumbers.getWinningNumbersInfo();
            LottoResult lottoResult = new LottoResult(winningNumbersInfo);
            lottoResult.getLottoResult(buyLottoInfo.getUserLottos(), buyLottoInfo.getUserMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
