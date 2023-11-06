package lotto.domain.controller;

import static java.lang.Math.round;
import static lotto.global.constant.LottoNumberType.LOTTO_AMOUNT_UNIT;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResultManager;
import lotto.domain.WinningLotto;
import lotto.domain.service.ClientService;
import lotto.domain.service.LottoService;
import lotto.global.constant.ConsoleType;
import lotto.global.utils.generator.NumbersGenerator;
import lotto.global.view.OutputView;

public class LottoController {

    private static final int PERCENTAGE_VALUE = 100;
    private static final double MULTIPLIER = 10.0;

    private final ClientService clientService;
    private final LottoService lottoService;
    private final NumbersGenerator numbersGenerator;

    public LottoController(ClientService clientService, LottoService lottoService, NumbersGenerator numbersGenerator) {
        this.clientService = clientService;
        this.lottoService = lottoService;
        this.numbersGenerator = numbersGenerator;
    }

    public void run() {
        long purchaseAmount = getPurchaseAmount();
        LottoResultManager lottoResultManager = lottoService.generateLottoNumbers(numbersGenerator,
                purchaseAmount / LOTTO_AMOUNT_UNIT.getValue());
        OutputView.outputLottoNumbers(lottoResultManager.getLottoResults());
        WinningLotto winningLotto = getWinningLotto();
        lottoResultManager.calculateResult(winningLotto);
        OutputView.outputStatistics(
                round(lottoResultManager.getTotalRevenue() / (double) purchaseAmount * PERCENTAGE_VALUE * MULTIPLIER)
                        / MULTIPLIER, lottoResultManager);
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        OutputView.commonOutputLine(ConsoleType.INPUT_BONUS_NUMBER.getComment());
        return clientService.getBonusNumber(winningNumbers);
    }

    private List<Integer> getWinningNumbers() {
        OutputView.commonOutputLine(ConsoleType.INPUT_WINNING_NUMBERS.getComment());
        return clientService.getWinningNumbers();
    }

    private long getPurchaseAmount() {
        OutputView.commonOutputLine(ConsoleType.INPUT_PURCHASE_AMOUNT.getComment());
        long purchaseAmount = clientService.getPurchaseAmount();
        OutputView.commonOutputLine(ConsoleType.EMPTY.getComment());
        OutputView.commonOutputLine(
                ConsoleType.OUTPUT_PURCHASE.getComment(String.valueOf(purchaseAmount / LOTTO_AMOUNT_UNIT.getValue())));
        return purchaseAmount;
    }
}
