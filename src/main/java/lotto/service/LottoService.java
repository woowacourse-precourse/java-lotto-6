package lotto.service;

import lotto.controller.LottoController;

public class LottoService {
    private static final LottoService instance = new LottoService();

    public static LottoService getInstance() {
        return instance;
    }

    private LottoService() {
    }

}
