package lotto.controller;

import lotto.domain.Lotto;
import lotto.dto.input.UserLottoDTO;
import lotto.view.LottoScreen;

public class RegisterLottoController extends AbstractController {
    private final LottoScreen lottoScreen;

    public RegisterLottoController(LottoScreen lottoScreen) {
        this.lottoScreen = lottoScreen;
    }

    @Override
    void doProcess() {
        UserLottoDTO userLottoDTO = lottoScreen.registerLotto();
        Lotto userLotto = userLottoDTO.toLotto();
    }
}
