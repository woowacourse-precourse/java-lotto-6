package lotto.service;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.service.generate.LottoManualGenerateService;
import lotto.vo.LottoBonusNumber;

import java.util.List;

public class LottoWinningNumbersPickService {
    private static final LottoWinningNumbersPickService instance = new LottoWinningNumbersPickService();
    private final LottoManualGenerateService lottoManualGenerator;

    private LottoWinningNumbersPickService() {
        this.lottoManualGenerator = LottoManualGenerateService.getInstance();
    }

    public static LottoWinningNumbersPickService getInstance() {
        return instance;
    }

    public Lotto pickWinningNumbers(String input) throws LottoException {
        List<String> splitLottoNumbers = splitLottoNumbers(input);
        return lottoManualGenerator.generate(splitLottoNumbers);
    }

    public LottoBonusNumber pickBonusNumber(String input) {
        return new LottoBonusNumber(Integer.parseInt(input));
    }

    private List<String> splitLottoNumbers(String input) {
        String delimiter = ",";
        return List.of(input.split(delimiter));
    }
}
