package lotto.domain;

import java.util.List;

public class LottoResult {
    public long lottoNumbersPurchased(long userLottoPrice) {
        return userLottoPrice / 1000;
    }
}
