package lotto.controller;

public class LottoController {
    public static LottoController getInstance() {
        return LottoController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LottoController INSTANCE = new LottoController();
    }
}
