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
        return Collections.nCopies(numberOfLottos, 0).stream()
                .map(n -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }
    public void printLottos() {
        System.out.println(purchaseAmount / PRICE_PER_LOTTO + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    public void checkResults(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean hasBonus = lotto.containsBonusNumber(bonusNumber);
            prizeResults.addResult(matchCount, hasBonus);
        }
        prizeResults.printResults();
    }
    public double calculateProfit() {
        int totalPrize = prizeResults.calculateTotalPrize();
        return (double) totalPrize / purchaseAmount * 100;
    }
}
