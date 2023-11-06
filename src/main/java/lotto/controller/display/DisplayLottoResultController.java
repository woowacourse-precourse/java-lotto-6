package lotto.controller.display;

import lotto.domain.LottoFinalResult;
import lotto.domain.LottoWithBonus;
import lotto.domain.UserMoney;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.LottoScreen;

public class DisplayLottoResultController implements DisplayController {
    private final LottoScreen lottoScreen;
    private final LottoWithBonus lottoWithBonus;
    private final UserMoney userMoney;
    private final LottoRepository lottoRepository;


    public DisplayLottoResultController(LottoScreen lottoScreen, LottoWithBonus lottoWithBonus,
                                        UserMoney userMoney, LottoRepository lottoRepository) {
        this.lottoScreen = lottoScreen;
        this.lottoWithBonus = lottoWithBonus;
        this.userMoney = userMoney;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void process() {
        LottoFinalResult lottoFinalResult = new LottoFinalResult();
        lottoRepository.getAllLottos()
                .forEach((lotto) -> lottoFinalResult.addLottoResult(
                                LottoService.compareLottoWithBonus(lottoWithBonus, lotto))
                );
        lottoScreen.displayLottoResult(lottoFinalResult);
        lottoScreen.displayRateOfReturn(LottoService.calculateRateOfReturn(lottoFinalResult, userMoney));
    }
}
