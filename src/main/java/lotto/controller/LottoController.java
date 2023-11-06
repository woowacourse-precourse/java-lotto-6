package lotto.controller;

import lotto.Service.LottoService;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.BonusRequestDTO;
import lotto.dto.LottoRequestDTO;
import lotto.dto.LottoResponseDTO;

public class LottoController {
    private static LottoController instance;
    private LottoService lottoService;

    private LottoController() {
        this.lottoService = LottoService.getInstance();
    }

    public static LottoController getInstance() {
        if (instance == null) {
            instance = new LottoController();
        }
        return instance;
    }

    public Lottos lottoSell(String money){
        return LottoService
                .getInstance()
                .lottoSell(money);
    }

    public Lotto createUserLottoNumber(String numbers){
        return LottoService
                .getInstance()
                .createLotto(numbers);
    }
    public int checkBonusNumber(BonusRequestDTO bonusRequestDTO){
        return LottoService
                .getInstance()
                .checkBonus(bonusRequestDTO);
    }

    public LottoResponseDTO CountScore(LottoRequestDTO lottoRequestDTO){
        return LottoService
                .getInstance()
                .countScore(lottoRequestDTO);
    }

}
