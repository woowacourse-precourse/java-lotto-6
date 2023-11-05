package lotto.controller;

import lotto.dto.input.UserMoneyDTO;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.LottoScreen;

public class LottoController {
    private final LottoRepository lottoRepository;
    private final LottoScreen lottoScreen;

    public LottoController(LottoRepository lottoRepository, LottoScreen lottoScreen) {
        this.lottoRepository = lottoRepository;
        this.lottoScreen = lottoScreen;
    }

    // 사용자로 부터 입력된 문자열 -> UserMoneyDTO를 받아와서
    // LottoController에서 DTO -> UserMoney까지 받아야 한다
    // generateRandomLotto(UserMoney, Repo..)
    public void registerUserMoney() {
        UserMoneyDTO inputUserMoney = lottoScreen.inputUserMoney();
        LottoService.generateRandomLotto(inputUserMoney.toUserMoney(), lottoRepository);
    }

}
