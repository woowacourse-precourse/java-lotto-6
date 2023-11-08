package lotto;

import util.OutputView;

public class LottoGame {
    private LottoStore lottoStore;
    private User user;

    LottoGame(LottoStore lottoStore, User user) {
        this.lottoStore = lottoStore;
        this.user = user;
    }

    public static LottoGame createLottoGame() {
        User user = User.createUser();
        LottoStore lottoStore = LottoStore.createLottoStore(user.getMoney()/1000);
        return new LottoGame(lottoStore, user);
    }

    public void startGame() {
        makeJudgement();
        makeStatistics();
    }
    private void makeJudgement() {
        lottoStore.judgeLotto(user.getLotto());
        OutputView.printResult(lottoStore.getWinCount());
    }
    private void makeStatistics() {
        int[] statisticsCount = lottoStore.getWinCount();
        double ratio = 0;
        double sumOfLotto = 0;
        int lottoCount = (user.getMoney() / 1000)*1000;

        sumOfLotto += statisticsCount[1] * 2000000000;
        sumOfLotto += statisticsCount[2] * 30000000;
        sumOfLotto += statisticsCount[3] * 1500000;
        sumOfLotto += statisticsCount[4] * 50000;
        sumOfLotto += statisticsCount[5] * 5000;
        ratio = (sumOfLotto / lottoCount)*100;
        ratio = Math.round(ratio * 1000) / 1000.0;

        OutputView.printStatistics(ratio);
    }
}
