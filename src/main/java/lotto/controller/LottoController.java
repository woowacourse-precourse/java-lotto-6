package lotto.controller;


import lotto.dto.*;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    private final String regex = "[0-9]+";
    private final Pattern pattern = Pattern.compile(regex);

    public LottosDto buyLotto(String input) throws Exception {
        validateInt(input.trim());
        int inputMoney = Integer.parseInt(input.trim());
        if (inputMoney % 1000 != 0 || inputMoney == 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }
        return lottoService.generateLottos(new LottoNumberDto(inputMoney / 1000));
    }

    public WinningNumberDto post1stNumber(String input) throws Exception {
        return lottoService.postNormalNumbers(convert2Dto(input));
    }

    public WinningNumberDto postBonusNumber(WinningNumberDto dto, String input) throws Exception {
        validateInt(input);
        int bonusNum = Integer.parseInt(input);
        return lottoService.postBonusNumber(dto, bonusNum);
    }

    public RanksDto calRanks(WinningNumberDto winningNumberDto, LottosDto lottosDto) {
        return lottoService.judgeRanks(winningNumberDto, lottosDto);
    }

    public RateOfReturnDto calReturnOfRate(LottoNumberDto lottoNumberDto, RanksDto ranksDto) {
        return lottoService.calRateOfReturn(lottoNumberDto, ranksDto);
    }

    private NumbersDto convert2Dto(String str) {
        String[] arr = str.split(",");
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (String s : arr) {
            validateInt(s.trim());
            result.add(Integer.parseInt(s.trim()));
        }

        result.sort(null);
        return new NumbersDto(result);
    }

    private void validateInt(String str) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자만을 입력해야 합니다.");
        }
    }
}
