package lotto.service;

import java.util.List;
import lotto.utils.LottoUtils;
import lotto.Lotto;

public class LottoService {
    LottoUtils lottoUtils = new LottoUtils();
    public void start() {
        List<Lotto> lottos = lottoUtils.setLottoResult(lottoUtils.setPurchaseAmout());
        lottoUtils.setLottoNumbers();
        lottoUtils.setBonusNumber();
    }
}