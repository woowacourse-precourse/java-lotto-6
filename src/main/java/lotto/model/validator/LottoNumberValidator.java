package lotto.model.validator;

import java.util.List;

public interface LottoNumberValidator {
    void checkNumberOfLottoNumbers(List<String> lottoNumbers);

    void checkBlankOfLottoNumbers(List<String> lottoNumbers);

    void checkInRangeOfLottoNumbers(List<Integer> lottoNumbers);

    void checkDuplicateLottoNumbers(List<Integer> lottoNumbers);
}
