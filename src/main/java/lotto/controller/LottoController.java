package lotto.controller;

import java.util.List;
import lotto.Service.LottoParseService;
import lotto.Service.LottoService;
import lotto.domain.Lotto;
import lotto.dto.CountScoreResponseDTO;

public class LottoController {
    private static LottoController instance;
    private LottoService lottoService;
    private LottoParseService lottoParseService;
    private LottoController() {
        this.lottoService = LottoService.getInstance();
        this.lottoParseService = LottoParseService.getInstance();
    }
    public static LottoController getInstance() {
        if (instance == null) instance = new LottoController();
        return instance;
    }

    public List<Lotto> setLottoBudget(String money) {
        int time = lottoParseService.parseTimes(money);
        return lottoService.buyLotto(time);
    }
    public void createUserLottoNumber(String numbers) {
        List<Integer> userNumbers = lottoParseService.parseList(numbers);
        Lotto userLotto = lottoParseService.parseLotto(userNumbers);
        lottoService.setUserLotto(userLotto);
    }
    public void createBonusNumber(String bonus) {
        int bonusNumber = lottoParseService.parseBonusNumber(bonus);
        lottoService.setBonus(bonusNumber);

    }
    public CountScoreResponseDTO countScore() {
        return lottoService.countScore();
    }
}
