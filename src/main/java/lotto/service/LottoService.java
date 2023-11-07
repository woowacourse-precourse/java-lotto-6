package lotto.service;

import lotto.utils.LottoUtils;

public class LottoService {
    LottoUtils lottoUtils = new LottoUtils();
    public void start() {
        Integer amount = lottoUtils.setPurchaseAmout();
        lottoUtils.setLottoResult(amount);
    }
}