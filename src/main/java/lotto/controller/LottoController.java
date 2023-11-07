package lotto.controller;

import java.util.List;
import lotto.Service.LottoParseService;
import lotto.Service.LottoService;
import lotto.domain.Lotto;
import lotto.dto.BonusRequestDTO;
import lotto.dto.CountScoreRequestDTO;
import lotto.dto.CountScoreResponseDTO;

public class LottoController {
    private static LottoController instance = new LottoController();
    private LottoService lottoService;
    private LottoParseService lottoParseService;
    private LottoController() {
        this.lottoService = LottoService.getInstance();
        this.lottoParseService = LottoParseService.getInstance();
    }
    public static LottoController getInstance() {
        return instance;
    }

    public List<Lotto> setLottoBudget(String money) {
        int time = lottoParseService.parseTimes(money);
        return lottoService.buyLotto(time);
    }
    public Lotto createUserLottoNumber(String numbers) {
        List<Integer> userNumbers = lottoParseService.parseList(numbers);
        return lottoParseService.parseLotto(userNumbers);
    }
    public int createBonusNumber(BonusRequestDTO bonusRequestDTO) {
        return lottoParseService.parseBonusNumber(bonusRequestDTO);
    }
    public CountScoreResponseDTO countScore(CountScoreRequestDTO countScoreRequestDTO) {
        return lottoService
                .countScore(countScoreRequestDTO);
    }
}
