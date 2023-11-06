package model;

import java.util.List;

public class LottoRepository {
    List<Lotto> lottos;

    private LottoRepository(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoRepository lottosOf(List<Lotto> lottos) {
        return new LottoRepository(lottos);
    }

    public int getSize() {
        return lottos.size();
    }

    public LottoPrize getWinningLotto(LottoWinningNumbers lottoWinningNumbers){
        return new LottoPrize(lottoWinningNumbers,lottos);
    }
}
