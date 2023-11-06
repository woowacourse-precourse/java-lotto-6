package lotto.controller;

import lotto.domain.GenerateLotto;
import lotto.domain.LottoJudge;
import lotto.domain.wrapper.*;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;

import java.util.List;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        Money money = loadTicket();

        BuyLottos buyLottos = buyLotto(money);

        Lotto winningLotto = loadWinningLotto();

        WinLottoWithBonus winLottoWithBonus = loadBonusNumber(winningLotto);

        LottoResult lottoResult = LottoStatistics(buyLottos, winLottoWithBonus);

        LottoProfit(lottoResult);
    }

    private Money loadTicket() {
        while (true) {
            try {
                outputHandler.printInputMoneyMessage();
                String money = inputHandler.inputValue();

                return Money.create(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BuyLottos buyLotto(Money money) {
        GenerateLotto generateLotto = GenerateLotto.create(money);
        List<Lotto> buyLottos = generateLotto.getBuyLottos();
        outputHandler.printBuyLottoList(buyLottos);

        return BuyLottos.create(buyLottos);
    }

    private Lotto loadWinningLotto() {
        while (true) {
            try {
                outputHandler.printInputWinningLottoMessage();
                String winningLotto = inputHandler.inputValue();

                return Lotto.from(winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinLottoWithBonus loadBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                outputHandler.printInputBonusLottoMessage();
                List<Integer> sortedNumbers = winningLotto.sortLottoNumbers();
                String bonusNumber = inputHandler.inputValue();

                return WinLottoWithBonus.create(sortedNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoResult LottoStatistics(BuyLottos buyLottos, WinLottoWithBonus winLottoWithBonus) {
        LottoJudge lottoJudge = LottoJudge.create(buyLottos, winLottoWithBonus);
        LottoResult lottoResult = lottoJudge.matchLottoHandler();

        outputHandler.printLottoResult(lottoResult);
        return lottoResult;
    }

    private void LottoProfit(LottoResult lottoResult) {
        outputHandler.printProfit(lottoResult);
    }
}
