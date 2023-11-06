package lotto.controller;

import lotto.domain.Bonus;
import lotto.dto.input.UserBonusDTO;
import lotto.view.LottoScreen;

public class RegisterBonusController extends RegisterAbstractController<Bonus> {
    private final LottoScreen lottoScreen;

    public RegisterBonusController(LottoScreen lottoScreen) {
        this.lottoScreen = lottoScreen;
    }

    @Override
    Bonus doProcess() {
        UserBonusDTO userBonusDTO = lottoScreen.registerBonus();
        return userBonusDTO.toBonus();
    }
}
