package lotto;

import lotto.repository.LottoRepository;
import lotto.repository.MemoryRandomLottoRepository;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.service.RateOfReturnCalculationService;
import lotto.service.RateOfReturnCalculationServiceImpl;
import lotto.service.WinningCalculationService;
import lotto.service.WinningCalculationServiceImpl;

public class Application {
    public static void main(String[] args) {
        LottoRepository lottoRepository = new MemoryRandomLottoRepository();

        LottoService lottoService = new LottoServiceImpl(lottoRepository);
        WinningCalculationService winningCalculationService = new WinningCalculationServiceImpl(lottoRepository);
        RateOfReturnCalculationService rateOfReturnCalculationService = new RateOfReturnCalculationServiceImpl();

        LottoGameManager lottoGameManager = new LottoGameManager(lottoService, winningCalculationService,
                rateOfReturnCalculationService);
        lottoGameManager.run();
    }
}
