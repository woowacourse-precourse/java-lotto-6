package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private final LocalScanner localScanner = new LocalScanner();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private LottoChecker lottoChecker;

    public void run() {
        purchaseLottos();
        //print lottos
        getLottoChecker();
        //print 당첨 통계
        //print 수익률
    }

    private void purchaseLottos() {
        int count = localScanner.getPurchasePrice();
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(randomNumberGenerator.generateUniqueAndRandomSixNumber()));
        }
    }

    private void getLottoChecker() {
        List<Integer> winningNumbers = localScanner.getWinningNumbers();
        int bonusNumber = localScanner.getBonusNumber();
        this.lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
    }

}
