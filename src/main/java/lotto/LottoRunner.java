package lotto;

import java.util.List;

public class LottoRunner {
    private final static LottoService lottoService = new LottoService();

    static void run() {
        List<Lotto> lottoList = lottoService.createLotto();
        lottoService.printLottoInfo(lottoList);
    }
}
