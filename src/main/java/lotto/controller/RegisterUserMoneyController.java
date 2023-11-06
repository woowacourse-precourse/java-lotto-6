package lotto.controller;

import lotto.dto.input.UserMoneyDTO;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.LottoScreen;

public class RegisterUserMoneyController extends AbstractController {
    private final LottoRepository lottoRepository;
    private final LottoScreen lottoScreen;

    public RegisterUserMoneyController(LottoRepository lottoRepository, LottoScreen lottoScreen) {
        this.lottoRepository = lottoRepository;
        this.lottoScreen = lottoScreen;
    }

    @Override
    void doProcess() {
        UserMoneyDTO inputUserMoney = lottoScreen.inputUserMoney();
        LottoService.generateRandomLotto(inputUserMoney.toUserMoney(), lottoRepository);
    }
}
