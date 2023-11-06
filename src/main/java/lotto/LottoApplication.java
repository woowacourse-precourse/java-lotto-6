package lotto;

import lotto.controller.RegisterLottoController;
import lotto.controller.RegisterUserMoneyController;
import lotto.io.ConsoleReader;
import lotto.io.ConsoleWriter;
import lotto.repository.LottoRepository;
import lotto.view.LottoScreen;

public class LottoApplication {
    private final LottoScreen lottoScreen;

    public LottoApplication(LottoScreen lottoScreen) {
        this.lottoScreen = lottoScreen;
    }

    void run() {
        // COntroller를 호출한다
        // 각각의 Controller 내에서 할일을 진행한다 (데이터의 교환을목적으로 진행한다
        // 단 핵심 로직은 Service 단에서 실행하는 방향으로
        registerUserMoney();
        registerUserLotto();

    }

    private void registerUserMoney() {
        new RegisterUserMoneyController(new LottoRepository(), lottoScreen).process();
    }

    private void registerUserLotto() {
        new RegisterLottoController(lottoScreen).process();
    }


}
