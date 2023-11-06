package lotto;

import lotto.controller.RegisterBonusController;
import lotto.controller.RegisterLottoController;
import lotto.controller.RegisterUserMoneyController;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.UserMoney;
import lotto.repository.LottoRepository;
import lotto.view.LottoScreen;

public class LottoApplication {
    private final LottoScreen lottoScreen;
    private final LottoRepository lottoRepository;

    public LottoApplication(LottoScreen lottoScreen, LottoRepository repository) {
        this.lottoScreen = lottoScreen;
        this.lottoRepository = repository;
    }

    void run() {
        // Controller 에서 원하는 객체를 반환하는 구간이다
        UserMoney userMoney = registerUserMoney();
        Lotto lotto = registerUserLotto();


    }

    private UserMoney registerUserMoney() {
        return new RegisterUserMoneyController(lottoRepository, lottoScreen).process();
    }

    private Lotto registerUserLotto() {
        return new RegisterLottoController(lottoScreen).process();
    }

    private Bonus registerUserBonus() {
        return new RegisterBonusController(lottoScreen).process();
    }


}
