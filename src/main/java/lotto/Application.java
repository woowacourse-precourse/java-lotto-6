package lotto;

import lotto.service.LottoGameService;

public class Application {
    public static void main(String[] args) {
        LottoGameService lottoGameService = new LottoGameService();
        lottoGameService.run();
    }
}
