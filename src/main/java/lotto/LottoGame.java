package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    final List<Lotto> lottos;
    private final int purchaseAmount;

    public LottoGame(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottos = generateLottos();
    }

    private void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Lotto> generateLottos() {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> immutableNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> numbers = new ArrayList<>(immutableNumbers);
            generatedLottos.add(new Lotto(numbers));
        }
        return generatedLottos;
    }

    public void printLottos() {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public WinningResult checkResults(Lotto winningLotto, int bonusNumber) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.checkWinning(winningLotto, bonusNumber);
            winningResult.addResult(rank);
        }
        return winningResult;
    }

    public double calculateEarningsRate(WinningResult result) {
        long totalEarnings = result.getTotalEarnings();
        return (double) totalEarnings / purchaseAmount * 100;
    }
}
