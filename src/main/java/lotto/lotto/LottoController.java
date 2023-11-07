package lotto.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.converter.ConvertService;
import lotto.number.LottoNumber;

public class LottoController {

    private final ConvertService convertService;
    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController(ConvertService convertService, LottoView lottoView, LottoService lottoService){
        this.lottoView = lottoView;
        this.convertService = convertService;
        this.lottoService = lottoService;
    }

    public void pickLottoNumber(){
        List<LottoNumber> normalNumber = Stream.concat(pickNormalNumber().stream(), Stream.of(pickBonusNumber()))
                .collect(Collectors.toList());
    }

    private List<LottoNumber> pickNormalNumber(){
        return convertService.stringToNormalNumberConverter(lottoView.inputNormalNumber());
    }

    private LottoNumber pickBonusNumber(){
        return convertService.stringToBonusNumberConverter(lottoView.inputBonusNumber());
    }


}
