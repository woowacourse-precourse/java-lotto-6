package lotto;

import lotto.repository.LottoRepository;
import lotto.repository.MemoryRandomLottoRepository;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

public class Application {
    public static void main(String[] args) {
        LottoRepository lottoRepository = new MemoryRandomLottoRepository();
        LottoService lottoService = new LottoServiceImpl(lottoRepository);

        LottoGameManager lottoGameManager = new LottoGameManager(lottoService);
        lottoGameManager.run();
    }
}
