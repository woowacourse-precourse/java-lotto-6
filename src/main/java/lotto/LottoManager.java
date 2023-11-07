package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoManager {

    private final LocalScanner localScanner = new LocalScanner();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final Viewer viewer = new Viewer();
    private final Integer lottoPrice = 1000;
    private LottoChecker lottoChecker;
    private Lottos lottos;

    public void run() {
        int inputPrice = localScanner.getPurchasePrice();
        purchaseLottos(inputPrice);
        viewer.printLottos(lottos);
        getLottoChecker();
        HashMap<Rank, Integer> result = lottos.getWinningResult(lottoChecker);
        printTotalWinningResult(result);
        printIncomeRating(result, inputPrice);
    }

    private void purchaseLottos(Integer inputPrice) {
        int count = inputPrice / lottoPrice;
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(randomNumberGenerator.generateUniqueAndRandomSixNumber()));
        }
        this.lottos = new Lottos(lottos);
    }

    private void getLottoChecker() {
        List<Integer> winningNumbers = localScanner.getWinningNumbers();
        int bonusNumber = localScanner.getBonusNumber();
        this.lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
    }

    private void printTotalWinningResult(HashMap<Rank, Integer> result) {
        viewer.printTotalWinningResult(result);
    }

    private void printIncomeRating(HashMap<Rank, Integer> result, Integer inputPrice) {
        long incomeMoney = 0;
        for (Rank rank : Rank.values()) {
            int rankMoney = rank.getMoney();
            int count = result.get(rank);
            incomeMoney += (long) rankMoney * count;
        }
        viewer.printIncomeRating(inputPrice, incomeMoney);
    }

}
