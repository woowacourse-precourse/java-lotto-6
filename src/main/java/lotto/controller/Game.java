package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Comparator;
import lotto.domain.Convertor;
import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.SameNumberCount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private static final int THOUSAND_UNIT = 1000;
    private int purchaseAmount;
    private Lotto winnerLotto;
    private int bonusNumber;

    public void start() {
        createPurchaseAmount();
        int purchaseQuantity = purchaseAmount / THOUSAND_UNIT;
        List<Lotto> lottos = issueLottos(purchaseQuantity);
        OutputView.printPurchaseResult(lottos);
        createWinnerLotto();
        createBonusNumber();
        List<SameNumberCount> sameNumberCounts = createSameNumbers(lottos, winnerLotto, bonusNumber);
        OutputView.printWinnerResult(sameNumberCounts);
        OutputView.printProfitRate(purchaseAmount);
    }

    private void createPurchaseAmount() {
        while (true) {
            try {
                purchaseAmount = InputView.askPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
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

    private void createWinnerLotto() {
        while (true) {
            try {
                winnerLotto = new Lotto(createWinnerNumbers());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private List<Integer> createWinnerNumbers() {
        Convertor convertor = new Convertor();
        return convertor.convertToNumbers(InputView.askWinnerNumbers());
    }


    private void createBonusNumber() {
        while (true) {
            try {
                bonusNumber = new Number(InputView.askBonusNumber()).getNumber();
                validateDuplicated();
                break;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private void validateDuplicated() {
        if (winnerLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    private List<SameNumberCount> createSameNumbers(List<Lotto> lottos, Lotto winnerLotto, int bonusNumber) {
        Comparator comparator = new Comparator();
        List<SameNumberCount> sameNumberCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int sameNumber = comparator.countSameNumber(lotto, winnerLotto);
            boolean hasBonusNumber = comparator.checkBonusNumber(lotto, bonusNumber);
            sameNumberCounts.add(new SameNumberCount(sameNumber, hasBonusNumber));
        }
        return sameNumberCounts;
    }

}
