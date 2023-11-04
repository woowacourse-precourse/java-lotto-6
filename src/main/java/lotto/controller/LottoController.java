package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.util.NumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Money money = getMoneyFromUser();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Lottos lottos = makeLottos(money.buyLotto(), numberGenerator);

    }

    private Money getMoneyFromUser() {
        outputView.printPurchaseMessage();
        String input = inputView.readInput();
        return Money.from(input);
    }

    private Lottos makeLottos(final int buyCount, final NumberGenerator numberGenerator) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < buyCount; count++) {
            List<Integer> generatedNumbers = numberGenerator.generateSortedList();
            Lotto lotto = Lotto.fromIntegerList(generatedNumbers);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }
}
