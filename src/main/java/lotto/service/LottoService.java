package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.dto.LottoResult;
import lotto.model.LottoNumber;

public class LottoService {

    private static LottoService lottoService;

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (lottoService == null) {
            lottoService = new LottoService();
        }
        return lottoService;
    }

    public LottoResult compare(List<LottoNumber> lottoNumbers, Lotto lotto) {
        return null;
    }
}
