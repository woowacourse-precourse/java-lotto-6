package lotto.service;

public class LottoService {
    public static LottoService getInstance() {
        return LottoService.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LottoService INSTANCE = new LottoService();
    }
}
