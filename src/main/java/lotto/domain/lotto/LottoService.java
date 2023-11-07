package lotto.domain.lotto;

import lotto.domain.number.LottoNumberService;

public class LottoService {
    private final LottoNumberService lottoNumberService;
    public static final int LOTTO_PRICE = 1000;

    public LottoService(LottoNumberService lottoNumberService){
        this.lottoNumberService = lottoNumberService;
    }

    public Lotto buyLotto(){
        return Lotto.forUserLotto(lottoNumberService.pickAutoNumbers());
    }
}
