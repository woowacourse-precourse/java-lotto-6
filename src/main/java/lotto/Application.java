package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        List<Lotto> purchasedLotto = lottoGame.purchaseLotto();

        System.out.println(purchasedLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers().toString());
        }

        LottoChecker lottoChecker = lottoGame.getResult();
        lottoGame.printScores(lottoChecker.getTotalScores(purchasedLotto));
        lottoGame.printProfitRate(lottoChecker.getTotalPrizes(purchasedLotto));
    }
}
