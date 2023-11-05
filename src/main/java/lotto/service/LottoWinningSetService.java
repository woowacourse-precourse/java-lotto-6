package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.exception.LottoException;
import lotto.vo.BonusNumber;

import java.util.List;

public class LottoWinningSetService {
    private static final String delimiter = ",";


    private static final LottoWinningSetService instance = new LottoWinningSetService();
    private final LottoManualGenerateService lottoManualGenerator;

    private LottoWinningSetService() {
        this.lottoManualGenerator = LottoManualGenerateService.getInstance();
    }

    public static LottoWinningSetService getInstance() {
        return instance;
    }

    public Lotto pickWinningNumbers(String input) throws LottoException {
        List<String> splitLottoNumbers = splitLottoNumbers(input);
        return lottoManualGenerator.generate(splitLottoNumbers);
    }

    public BonusNumber pickBonusNumber(String input) {
        return new BonusNumber(Integer.parseInt(input));
    }

    private static List<String> splitLottoNumbers(String input) {
        return List.of(input.split(delimiter));
    }

}
