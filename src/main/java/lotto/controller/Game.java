package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Rank;
import lotto.domain.Comparator;
import lotto.domain.Convertor;
import lotto.domain.Judge;
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
        List<Integer> sameNumbers = createSameNumbers(lottos, winnerNumbers);
        List<Rank> ranks = createRanks(sameNumbers, lottos, bonusNumber);
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

    private List<Integer> createSameNumbers(List<Lotto> lottos, Lotto winnerNumbers) {
        List<Integer> sameNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int sameNumber = Comparator.countSameNumber(lotto, winnerNumbers);
            sameNumbers.add(sameNumber);
        }
        return sameNumbers;
    }

    private List<Rank> createRanks(List<Integer> sameNumbers, List<Lotto> lottos, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        Judge judge = new Judge();
        for (int i = 0; i < sameNumbers.size(); i++) {
            Rank rank = judge.selectRank(sameNumbers.get(i), lottos.get(i), bonusNumber);
            ranks.add(rank);
        }
        return ranks;
    }
}
