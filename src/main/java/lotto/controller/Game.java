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
            Lotto winnerLotto = createWinnerLotto();
            int bonusNumber = createBonusNumber(winnerLotto);
            List<SameNumber> sameNumbers = createSameNumbers(lottos, winnerLotto, bonusNumber);
            OutputView.printWinnerResult(sameNumbers, purchaseAmount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
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

    private Lotto createWinnerLotto() {
        Convertor convertor = new Convertor();
        return new Lotto(convertor.convertToNumbers(InputView.askWinnerNumbers()));
    }

    private int createBonusNumber(Lotto winnerLotto) {
        int bonusNumber = new Number(InputView.askBonusNumber()).getNumber();
        validateDuplicated(bonusNumber, winnerLotto);
        return bonusNumber;
    }

    private void validateDuplicated(int bonusNumber, Lotto winnerLotto) {
        if (winnerLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    private List<SameNumber> createSameNumbers(List<Lotto> lottos, Lotto winnerLotto, int bonusNumber) {
        Comparator comparator = new Comparator();
        List<SameNumber> sameNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int sameNumber = comparator.countSameNumber(lotto, winnerLotto);
            boolean hasBonusNumber = comparator.checkBonusNumber(lotto, bonusNumber);
            sameNumbers.add(new SameNumber(sameNumber, hasBonusNumber));
        }
        return sameNumbers;
    }

}
