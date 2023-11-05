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
            LottoResult lottoResult = winningLotto.compareToLotto(lottos.get(i));
            if (lottoResult.getWinners() == null) {
                continue;
            }
            lottosResult.put(lottoResult.getWinners(), lottosResult.get(lottoResult.getWinners()) + 1);
        }
        return lottosResult;
    }

}
