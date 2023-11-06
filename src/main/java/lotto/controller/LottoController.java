package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        Money money = getMoney();
        Lottos lottos = getLottos(money.getTicket());

        OutputView.printBuyLotto(money);
        OutputView.printLottos(lottos);

        List<Integer> winningNumber = InputView.getWinningNumber();
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
}
