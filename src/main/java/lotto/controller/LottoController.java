package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.util.LottoGenerator.generateLottos;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = askMoney();

        Lottos lottos = buyLottos(money.getCount());

        TotalWinningNumbers winningNumbers = askTotalWinningNumbers();

        LottoResult lottoResult = winningNumbers.checkLottos(lottos);

        outputView.printLottosResult(lottoResult.getResults());

        outputView.printRateOfReturn(lottoResult.getRateOfReturn(money));
    }

    private Money askMoney() {
        Money money;
        try{
            money = new Money(inputView.requestMoney());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askMoney();
        }
        outputView.printLottoCount(money.getCount());
        return money;
    }

    private Lottos buyLottos(int count) {
        Lottos lottos;
        try{
            lottos = new Lottos(generateLottos(count));
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLottos(count);
        }
        printBuyResult(lottos);
        return lottos;
    }

    private void printBuyResult(Lottos lottos){
        lottos.getLottos()
                .forEach(lotto -> outputView.printLottoNumbers(lotto.getNumbers()));
    }

    private TotalWinningNumbers askTotalWinningNumbers() {
        Lotto winningNumbers = askWinningNumbers();
        return makeTotalWinningNumbers(winningNumbers);
    }

    private Lotto askWinningNumbers() {
        try{
            return new Lotto(inputView.requestWinningNumbers());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askWinningNumbers();
        }
    }

    private TotalWinningNumbers makeTotalWinningNumbers(Lotto lotto) {
        int bonus = inputView.requestBonusNumber();
        try{
            return new TotalWinningNumbers(lotto, bonus);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeTotalWinningNumbers(lotto);
        }
    }
}
