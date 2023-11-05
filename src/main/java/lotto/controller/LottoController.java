package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    NumberGenerator numberGenerator = new NumberGenerator();

    public void start() {
        Money money = getValidMoneyInput();
        printTicketCountAndOutput(money);
    }

    private Money getValidMoneyInput() {
        Money money = null;
        while (money == null) {
            try {
                money = new Money(InputView.getMoneyInput());
            } catch (IllegalArgumentException e) {
                OutputView.printException(e);
            }
        }
        return money;
    }

    private void printTicketCountAndOutput(Money money) {
        int ticketCount = money.calculateLottoCount();
        OutputView.printTicketCount(ticketCount);
    }

    private List<Lotto> createLotto(int money) {
        int lottoCount = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(numberGenerator.createRandomLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

}