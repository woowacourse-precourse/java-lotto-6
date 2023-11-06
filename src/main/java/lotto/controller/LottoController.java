package lotto.controller;

import static lotto.etc.ErrorConstant.LOW_THOUSAND_ERROR;
import static lotto.etc.ErrorConstant.NOT_DIVIDE_THOUSAND_ERROR;
import static lotto.etc.SystemConstant.THREE_ZERO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.dto.BonusRequestDTO;
import lotto.dto.CountScoreRequestDTO;
import lotto.dto.CountScoreResponseDTO;
import lotto.etc.Validate;
import lotto.Service.LottoService;

public class LottoController {
    private static LottoController instance = new LottoController();
    private LottoService lottoService;

    private LottoController() {
        this.lottoService = LottoService.getInstance();
    }

    public static LottoController getInstance() {
        return instance;
    }
    public List<Lotto> setLottoBudget(String money) {
        int time = validate(money);
        return lottoService.buyLotto(time);
    }

    public Lotto createUserLottoNumber(String numbers) {
        List<Integer> userNumbers = parseList(numbers);
        return lottoService.createLotto(userNumbers);
    }
    public int createBonusNumber(BonusRequestDTO bonusRequestDTO) {

        return lottoService
                .createBonusNumber(bonusRequestDTO);
    }

    public CountScoreResponseDTO countScore(CountScoreRequestDTO countScoreRequestDTO) {
        return lottoService
                .countScore(countScoreRequestDTO);
    }
    private List<Integer> parseList(String numbers) {
        List<Integer> lottoNumbers = Arrays
                .stream(numbers.split(","))
                .map(Validate::validateNumber)
                .collect(Collectors.toList());
        return lottoNumbers;
    }
    private int validate(String time) {
        if (time.length() <= 3) {
            throw new IllegalArgumentException(LOW_THOUSAND_ERROR.toString());
        }

        String lastThreeChars = time.substring(time.length() - 3);
        if (!lastThreeChars.equals(THREE_ZERO.toString())) {
            throw new IllegalArgumentException(NOT_DIVIDE_THOUSAND_ERROR.toString());
        }

        return Integer.parseInt(time) / 1000;
    }

}
