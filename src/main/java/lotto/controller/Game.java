package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Comparator;
import lotto.domain.Convertor;
import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.SameNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private static final int THOUSAND_UNIT = 1000;

    public void start() {
        try {
            int purchaseAmount = InputView.askPurchaseAmount();
            int purchaseQuantity = purchaseAmount / THOUSAND_UNIT;
            List<Lotto> lottos = issueLottos(purchaseQuantity);
            OutputView.printPurchaseResult(lottos);
            Lotto winnerNumbers = createWinnerNumbers();
            int bonusNumber = createBonusNumber();
            List<SameNumber> sameNumbers = createSameNumbers(lottos, winnerNumbers, bonusNumber);
            OutputView.printWinnerResult(sameNumbers, purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
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
        Number bonusNumber = new Number(InputView.askBonusNumber());
        return bonusNumber.getNumber();
    }

    private List<SameNumber> createSameNumbers(List<Lotto> lottos, Lotto winnerNumbers, int bonusNumber) {
        Comparator comparator = new Comparator();
        List<SameNumber> sameNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int sameNumber = comparator.countSameNumber(lotto, winnerNumbers);
            boolean hasBonusNumber = comparator.checkBonusNumber(lotto, bonusNumber);
            sameNumbers.add(new SameNumber(sameNumber, hasBonusNumber));
        }
        return sameNumbers;
    }

}
