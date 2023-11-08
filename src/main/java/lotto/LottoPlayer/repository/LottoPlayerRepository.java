package lotto.LottoPlayer.repository;

import lotto.LottoPlayer.entity.LottoPlayer;

public class LottoPlayerRepository {

    private static final LottoPlayerRepository instance = new LottoPlayerRepository();

    public static LottoPlayerRepository getInstance() {
        return instance;
    }

    private LottoPlayerRepository() {}

    private LottoPlayer lottoPlayer = new LottoPlayer();

    public void setLottoPlayer(LottoPlayer lottoPlayer) {
        this.lottoPlayer = lottoPlayer;
    }

    public LottoPlayer getLottoPlayer() {
        return lottoPlayer;
    }
}
