package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LottoManager {

    private final LocalScanner localScanner = new LocalScanner();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private final Viewer viewer = new Viewer();
    private LottoChecker lottoChecker;
    private Lottos lottos;

    public void run() {
        purchaseLottos();
        viewer.printLottos(lottos);
        getLottoChecker();
        HashMap<Rank, Integer> result = lottos.getWinningResult(lottoChecker);
        printWinningResult(result);
        //print 수익률
    }

    private void purchaseLottos() {
        int count = localScanner.getPurchasePrice();
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

    private void printWinningResult(HashMap<Rank, Integer> result) {
        System.out.println("당첨 통계\n---");
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .forEach(rank -> viewer.printWinningResult(rank.getMessage(), result.get(rank)));
    }

}
