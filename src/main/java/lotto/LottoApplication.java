package lotto;

import lotto.controller.RegisterLottoController;
import lotto.controller.RegisterUserMoneyController;
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
        // COntroller를 호출한다
        // 각각의 Controller 내에서 할일을 진행한다 (데이터의 교환을목적으로 진행한다
        // 단 핵심 로직은 Service 단에서 실행하는 방향으로
        UserMoney userMoney = registerUserMoney();
        Lotto lotto = registerUserLotto();


    }

    private UserMoney registerUserMoney() {
        return new RegisterUserMoneyController(lottoRepository, lottoScreen).process();
    }

    private Lotto registerUserLotto() {
        return new RegisterLottoController(lottoScreen).process();
    }


}
