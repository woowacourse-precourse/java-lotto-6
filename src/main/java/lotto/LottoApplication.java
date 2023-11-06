package lotto;

import lotto.controller.display.DisplayLottoController;
import lotto.controller.display.DisplayLottoResultController;
import lotto.controller.register.RegisterBonusController;
import lotto.controller.register.RegisterLottoController;
import lotto.controller.register.RegisterUserMoneyController;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoWithBonus;
import lotto.domain.UserMoney;
import lotto.repository.LottoRepository;
import lotto.view.LottoScreen;

public class LottoApplication {
    private final LottoScreen lottoScreen;
    private final LottoRepository lottoRepository;

    public LottoApplication(LottoScreen lottoScreen, LottoRepository lottoRepository) {
        this.lottoScreen = lottoScreen;
        this.lottoRepository = lottoRepository;
    }

    void run() {
        // Controller 에서 원하는 객체를 반환하는 구간이다
        UserMoney userMoney = registerUserMoney();

        displayGeneratedLotto(userMoney);

        Lotto userLotto = registerUserLotto();
        Bonus userBonus = registerUserBonus(userLotto);

        LottoWithBonus userTicket = LottoWithBonus.of(userLotto, userBonus);
        displayLottoResult(userTicket, userMoney, lottoRepository);
    }

    private UserMoney registerUserMoney() {
        UserMoney userMoney = new RegisterUserMoneyController(lottoRepository, lottoScreen).process();
        if (userMoney == null) {
            throw new IllegalStateException();
        }
        return userMoney;
    }

    private void displayGeneratedLotto(UserMoney userMoney) {
        new DisplayLottoController(userMoney, lottoRepository, lottoScreen).process();
    }

    private Lotto registerUserLotto() {
        return new RegisterLottoController(lottoScreen).process();
    }

    private Bonus registerUserBonus(Lotto userLotto) {
        return new RegisterBonusController(lottoScreen, userLotto).process();
    }

    private void displayLottoResult(LottoWithBonus userLottoWithBonus, UserMoney userMoney,
                                    LottoRepository lottoRepository) {
        new DisplayLottoResultController(lottoScreen, userLottoWithBonus, userMoney, lottoRepository).process();
    }
}
