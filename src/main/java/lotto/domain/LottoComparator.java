package lotto.domain;

import lotto.common.consts.ErrorMessage;

public class LottoComparator {
    private Lottos lottos;
    private WinningLotto winningLotto;

    public LottoComparator(Lottos lottos, WinningLotto winningLotto) {
        validate(lottos, winningLotto);
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    private void validate(Lottos lottos, WinningLotto winningLotto) {
        if (lottos == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE);
        }
        if (winningLotto == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE);
        }
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
