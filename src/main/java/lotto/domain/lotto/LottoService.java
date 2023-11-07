package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberService;

import java.util.List;

public class LottoService {
    private final LottoNumberService lottoNumberService;
    public static final int LOTTO_PRICE = 1000;

    public LottoService(LottoNumberService lottoNumberService){
        this.lottoNumberService = lottoNumberService;
    }

    public Lotto buyLotto(){
        return Lotto.forUserLotto(lottoNumberService.pickAutoNumbers());
    }

    public RaffleLottoResponse raffleLotto(List<LottoNumber> lottoNumbers){
        return new RaffleLottoResponse(Lotto.raffle(lottoNumbers));
    }

    public RaffleLottoResponse addBonusNumber(Lotto lotto, LottoNumber lottoNumber){
        lotto.addBonusNumber(lottoNumber);
        return new RaffleLottoResponse(lotto);
    }
}
