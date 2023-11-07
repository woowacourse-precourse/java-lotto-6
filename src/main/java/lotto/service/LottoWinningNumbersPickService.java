package lotto.service;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.service.generate.LottoManualGenerateService;
import lotto.vo.LottoWinningBonusNumber;

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

    public Lotto pickWinningNumbers(final String input) throws LottoException {
        List<String> splitLottoNumbers = splitLottoNumbers(input);
        return lottoManualGenerator.generate(splitLottoNumbers);
    }

    public LottoWinningBonusNumber pickBonusNumber(final String input) {
        return new LottoWinningBonusNumber(Integer.parseInt(input));
    }

    private List<String> splitLottoNumbers(final String input) {
        String delimiter = ",";
        return List.of(input.split(delimiter));
    }
}
