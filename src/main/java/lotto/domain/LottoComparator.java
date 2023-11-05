package lotto.domain;

public class LottoComparator {
    private Lottos lottos;
    private WinningLotto winningLotto;

    public LottoComparator(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }


    public LottosResult compareLottoAndWinningLotto() {
        LottosResult lottosResult = new LottosResult();
        for (int i = 0; i < lottos.size(); i++) {
            LottoScore lottoScore = winningLotto.calculateLottoScore(lottos.get(i));
            if (lottoScore.getWinners() == null) {
                continue;
            }
            lottosResult.put(lottoScore.getWinners(), lottosResult.get(lottoScore.getWinners()) + 1);
        }
        return lottosResult;
    }

}
