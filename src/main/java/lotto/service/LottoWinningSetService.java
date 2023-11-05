package lotto.service;

import lotto.domain.generator.LottoManualGenerator;
import lotto.domain.lotto.Lotto;
import lotto.exception.LottoException;
import lotto.vo.BonusNumber;

import java.util.List;

public class LottoWinningSetService {

    private static final String delimiter = ",";

    private final LottoManualGenerator lottoManualGenerator = new LottoManualGenerator();

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
