package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    public static final int PRICE_PER_LOTTO = 1000;
    private final List<Lotto> lottos;
    private final int purchaseAmount;
    private final PrizeResults prizeResults;

    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = generateLottos(purchaseAmount / PRICE_PER_LOTTO);
        this.prizeResults = new PrizeResults();
    }
    private List<Lotto> generateLottos(int numberOfLottos) {

    }
    public void printLottos() {

    }
    public void checkResults(List<Integer> winningNumbers, int bonusNumber) {

    }
    public double calculateProfit() {

    }
}
