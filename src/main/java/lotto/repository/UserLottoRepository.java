package lotto.repository;

import lotto.model.LottoWallet;

public class UserLottoRepository {

    private LottoWallet lottoWallet;

    public LottoWallet saveLottoWallet(LottoWallet lottoWallet) {
        this.lottoWallet = lottoWallet;
        return lottoWallet;
    }

    public LottoWallet getLottoWallet() {
        return lottoWallet;
    }

}
