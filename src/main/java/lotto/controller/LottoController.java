package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        Money money = getMoney();
        Lottos lottos = getLottos(money.getTicket());

        OutputView.printBuyLotto(money);
        OutputView.printLottos(lottos);

        WinningNumber winningNumber = getWinningNumber();
        RankResult rankResult = new RankResult();
        calcLottoResult(rankResult, winningNumber, lottos);

        Rate rate = getRate(money, rankResult);
        OutputView.printResult(rankResult);
    }

    private String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int convertMoney(String input) {
        return Integer.parseInt(input);
    }

    private Money getMoney() {
        int money = convertMoney(inputMoney());
        return new Money(money);
    }

    private Lottos getLottos(int ticket) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(ticket));
    }

    private WinningNumber getWinningNumber() {
        InputView inputView = new InputView();

        List<Integer> winningNumbers = inputView.getWinningNumber();
        Integer bonusNumber = inputView.getBonusNumber();

        return new WinningNumber(winningNumbers, bonusNumber);
    }

    private void calcLottoResult(RankResult rankResult, WinningNumber winningNumber, Lottos lottos) {
        rankResult.calculateRankResult(winningNumber, lottos);
    }

    private Rate getRate(Money money, RankResult rankResult) {
        return new Rate(money, rankResult);
    }
}
