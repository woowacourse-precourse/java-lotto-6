package lotto.domain.lotto;

import java.util.List;
import lotto.domain.converter.ConvertService;
import lotto.domain.number.LottoNumber;

public class LottoController {

    private final ConvertService convertService;
    private final LottoService lottoService;

    public LottoController(ConvertService convertService, LottoService lottoService){
        this.convertService = convertService;
        this.lottoService = lottoService;
    }

    public RaffleLottoResponse raffleLotto(String input){
        List<LottoNumber> lotto = convertService.stringToNormalNumberConverter(input);
        return lottoService.raffleLotto(lotto);
    }

    public RaffleLottoResponse pickBonusNumber(Lotto lotto, String input){
        LottoNumber lottoNumber = convertService.stringToBonusNumberConverter(input);
        return lottoService.addBonusNumber(lotto, lottoNumber);
    }


}
