package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Comparator;
import lotto.domain.Convertor;
import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private static final int THOUSAND_UNIT = 1000;

    public void start() {
        int purchaseQuantity = InputView.askPurchaseAmount() / THOUSAND_UNIT;
        List<Lotto> lottos = issueLottos(purchaseQuantity);
        OutputView.printPurchaseResult(lottos);
        Lotto winnerNumbers = createWinnerNumbers();
        int bonusNumber = createBonusNumber();
        Comparator comparator = new Comparator();
    }

    private List<Lotto> issueLottos(int purchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            Lotto lotto = new Lotto(Lotto.issueLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto createWinnerNumbers() {
        Convertor convertor = new Convertor();
        return new Lotto(convertor.convertToNumbers(InputView.askWinnerNumbers()));
    }

    private int createBonusNumber() {
        return new Number(InputView.askBonusNumber()).getNumber();
    }
}
