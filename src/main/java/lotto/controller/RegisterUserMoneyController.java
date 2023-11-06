package lotto.controller;

import lotto.domain.UserMoney;
import lotto.dto.input.UserMoneyDTO;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.LottoScreen;

public class RegisterUserMoneyController extends RegisterAbstractController<UserMoney> {
    private final LottoRepository lottoRepository;
    private final LottoScreen lottoScreen;

    public RegisterUserMoneyController(LottoRepository lottoRepository, LottoScreen lottoScreen) {
        this.lottoRepository = lottoRepository;
        this.lottoScreen = lottoScreen;
    }

    @Override
    UserMoney doProcess() {
        UserMoneyDTO inputUserMoney = lottoScreen.inputUserMoney();
        LottoService.generateRandomLotto(inputUserMoney.toUserMoney(), lottoRepository);
        return inputUserMoney.toUserMoney();
    }
}
