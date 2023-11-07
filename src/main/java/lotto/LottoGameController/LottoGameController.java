package lotto.LottoGameController;

import lotto.MATCHING;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.util.Utils;
import lotto.service.InputService;
import lotto.service.OutputService;

import java.util.*;

public class LottoGameController {

    private final InputService inputService;
    private final OutputService outputService;
    private final LottoService lottoService;

    public LottoGameController(InputService inputService, OutputService outputService, LottoService lottoService) {
        this.inputService = inputService;
        this.outputService = outputService;
        this.lottoService = lottoService;
    }

    public void start() {

        Integer purchaseAmount = inputService.getPurchaseAmount();
        outputService.printPurchaseAmount(purchaseAmount);
        List<Lotto> lottoes = lottoService.createLotto(purchaseAmount);
        outputService.printLottoNumbers(lottoes);
        HashSet<Integer> winningNumbers = inputService.getWinningNumbers();
        Integer bonusNumber = inputService.getBonusNumber(winningNumbers);
        HashMap<Integer, Integer> result = lottoService.getResult(lottoes, bonusNumber, winningNumbers);
        double profit = lottoService.calculateProfitRate(purchaseAmount, result);
        outputService.printResult(result, profit);
    }
}
