package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lottos;
import lotto.service.CalculateService;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.OutputService;

import java.util.HashMap;

public class Controller {
    private final InputService inputService = new InputService();
    private final LottoService lottoService = new LottoService();
    private final OutputService outputService = new OutputService();
    private final CalculateService calculateService = new CalculateService();
    private Buyer buyer;
    private Lottos lottos;

    public void run() {
        buyer = inputService.inputPurchaseAmount();
        lottos = lottoService.issueLottos(buyer);
        outputService.printLottos(lottos, buyer);
        int[] buyerLottoNumbers = inputService.inputLottoNumber();
        int buyerBonusNumber = inputService.inputBounusNumber(buyerLottoNumbers);
        HashMap<String,Integer> winningPrize = calculateService.calculateWinningPrize(lottos, buyerLottoNumbers, buyerBonusNumber);
    }
}
