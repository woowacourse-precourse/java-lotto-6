package lotto.controller.register;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.dto.UserBonusDTO;
import lotto.exception.ExceptionMessage;
import lotto.view.LottoScreen;

public class RegisterBonusController extends RegisterAbstractController<Bonus> {
    private final LottoScreen lottoScreen;
    private final Lotto userLotto;

    public RegisterBonusController(LottoScreen lottoScreen, Lotto userLotto) {
        this.lottoScreen = lottoScreen;
        this.userLotto = userLotto;
    }

    @Override
    Bonus doProcess() {
        UserBonusDTO userBonusDTO = lottoScreen.registerBonus();
        Bonus userBonus = userBonusDTO.toBonus(userLotto);
        return userBonus;
    }
}
