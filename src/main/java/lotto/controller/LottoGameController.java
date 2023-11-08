package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lotto.StringConstants;
import lotto.adapter.LottoPrinter;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.port.InputPort;
import lotto.port.OutputPort;
import lotto.service.LottoNumberGenerationService;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultCalculationService;
import lotto.service.LottoWinningNumberService;


public class LottoGameController {

    private final InputPort inputPort;
    private final OutputPort outputPort;
    private final LottoNumberGenerationService lottoNumberGenerationService;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoResultCalculationService lottoResultCalculationService;
    private final LottoWinningNumberService lottoWinningNumberService;
    private final LottoPrinter lottoPrinter;


    public LottoGameController(InputPort inputPort, OutputPort outputPort,
            LottoNumberGenerationService lottoNumberGenerationService,
            LottoPurchaseService lottoPurchaseService,
            LottoResultCalculationService lottoResultCalculationService,
            LottoWinningNumberService lottoWinningNumberService,
            LottoPrinter lottoPrinter) {

        this.inputPort = inputPort;
        this.outputPort =outputPort;
        this.lottoNumberGenerationService = lottoNumberGenerationService;
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoResultCalculationService = lottoResultCalculationService;
        this.lottoWinningNumberService = lottoWinningNumberService;
        this.lottoPrinter =lottoPrinter;
    }

    public void playGame() {
        List<Lotto> userLottoNumbers = buyLottoTickets();
        WinningLotto winningLotto = inputWinningAndBonusNumber();
        Map<Integer, Integer> matchingCounts = lottoResultCalculationService.calculateMatchingCounts(userLottoNumbers, winningLotto);
        lottoResultCalculationService.printStatistics(matchingCounts);
        lottoResultCalculationService.printReturnRate(matchingCounts, userLottoNumbers.size());
    }

    private List<Lotto> buyLottoTickets() {
        return getInputWithValidation(
                () -> {
                    String purchaseAmount = getPurchaseAmount();
                    return printLottoNumbers(purchaseAmount);
                }
        );
    }

    private WinningLotto inputWinningAndBonusNumber() {
        return getInputWithValidation(
                () -> {
                    String winningNumbers = getWinningNumbers();
                    String bonusNumber = getBonusNumber();
                    return lottoWinningNumberService.createWinningLotto(winningNumbers,bonusNumber);
                }
        );
    }

    private String getPurchaseAmount() {
        outputPort.printLine(StringConstants.INPUT_PURCHASEAMOUNT_MESSAGE);
        return inputPort.readLine();
    }

    private String getWinningNumbers() {
        outputPort.printEmptyLine();
        outputPort.printLine(StringConstants.INPUT_WINNING_NUMBER_MESSAGE);
        return inputPort.readLine();
    }

    private String getBonusNumber() {
        outputPort.printEmptyLine();
        outputPort.printLine(StringConstants.INPUT_BONUS_NUMBER_MESSAGE);
        return inputPort.readLine();
    }

    private List<Lotto> printLottoNumbers(String purchaseAmount) {
        outputPort.printEmptyLine();
        int lottoTicketsCount = lottoPurchaseService.calculateNumberOfLottoTickets(purchaseAmount);
        List<Lotto> issuedTickets = lottoNumberGenerationService.generateLottoNumbers(lottoTicketsCount);
        lottoPrinter.printLottoTickets(issuedTickets);
        return issuedTickets;
    }

    private <T> T getInputWithValidation(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputPort.printLine(e.getMessage());
            }
        }
    }
}
