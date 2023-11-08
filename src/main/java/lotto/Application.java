package lotto;

import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = LottoService.getInstance();
        lottoService.executeLotto();
        lottoService.displayResult();
    }
}
