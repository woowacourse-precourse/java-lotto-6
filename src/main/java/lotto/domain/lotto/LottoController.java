package lotto.domain.lotto;

import java.util.List;
import lotto.domain.converter.ConvertService;
import lotto.domain.number.LottoNumber;
import lotto.domain.user.User;

public class LottoController {

    private final ConvertService convertService;
    private final LottoService lottoService;

    public LottoController(ConvertService convertService, LottoService lottoService){
        this.convertService = convertService;
        this.lottoService = lottoService;
    }

    public List<LottoResultResponse> getLottoStatistics(final User user, final Lotto raffledLotto){
        return lottoService.getLottoStatistics(user, raffledLotto);
    }
    public RaffleLottoResponse raffleLotto(final String input){
        List<LottoNumber> lotto = convertService.stringToNormalNumberConverter(input);
        return lottoService.raffleLotto(lotto);
    }

    public RaffleLottoResponse pickBonusNumber(final Lotto lotto, final String input){
        LottoNumber lottoNumber = convertService.stringToBonusNumberConverter(input);
        return lottoService.addBonusNumber(lotto, lottoNumber);
    }


}
