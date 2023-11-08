package lotto;

import lotto.service.LottoService;

public class Application {
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        lottoService.start();
    }
}
