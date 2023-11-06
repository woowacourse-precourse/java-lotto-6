package lotto.service;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.service.generate.LottoManualGenerateService;
import lotto.vo.LottoBonusNumber;

import java.util.List;

public class LottoWinningService {
    private static final LottoWinningService instance = new LottoWinningService();
    private final LottoManualGenerateService lottoManualGenerator;

    private LottoWinningService() {
        this.lottoManualGenerator = LottoManualGenerateService.getInstance();
    }

    public static LottoWinningService getInstance() {
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
