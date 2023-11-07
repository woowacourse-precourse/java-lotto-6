package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.ReturnsRate;
import lotto.domain.TicketCount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.exception.ErrorMessage;
import lotto.generator.LottoNumbersGenerator;
import lotto.generator.LottosGenerator;
import lotto.parser.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static LottoController create(InputView inputView, OutputView outputView) {
        return new LottoController(inputView, outputView);
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmountFromInput();
        TicketCount ticketCount = getTicketCount(purchaseAmount);
        Lottos lottos = createLottos(ticketCount);
        displayLottosInfo(ticketCount, lottos);
        startLotto(lottos, purchaseAmount);
    }

    private void startLotto(Lottos lottos, PurchaseAmount purchaseAmount) {
        WinningLotto winningLotto = getWinningLottoFromInput();
        WinningResult winningResult = getPrizeResult(winningLotto, lottos);
        outputView.displayWinningStatics(winningResult.toDto());
        ReturnsRate returnsRate = ReturnsRate.create(purchaseAmount, winningResult);
        outputView.displayReturnsRate(returnsRate.toDto());
    }

    private WinningResult getPrizeResult(WinningLotto winningLotto, Lottos lottos) {
        outputView.displayResultTop();
        WinningResult winningResult = WinningResult.create();
        winningResult.calWinningResult(winningLotto, lottos);
        return winningResult;
    }

    private void displayLottosInfo(TicketCount ticketCount, Lottos lottos) {
        outputView.displayTicketCount(ticketCount);
        outputView.displayLottos(lottos);
    }

    private PurchaseAmount getPurchaseAmountFromInput() {
        try {
            String input = inputView.requestPurchaseAmount();
            return PurchaseAmount.create(Parser.parsePurchaseAmount(input));
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return getPurchaseAmountFromInput();
        }
    }

    private WinningLotto getWinningLottoFromInput() {
        try {
            Lotto winningLotto = getWinningNumbersFromInput();
            BonusNumber bonusNumber = getBonusNumberFromInput();
            validateDuplication(winningLotto, bonusNumber);
            return WinningLotto.create(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return getWinningLottoFromInput();
        }
    }

    private void validateDuplication(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.isContain(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WIN_BONUS_NUM.getErrorMessage());
        }
    }

    private Lotto getWinningNumbersFromInput() {
        try {
            String inputLottoNumbers = inputView.requestLottoWinningNumbers();
            return Parser.parseLottoWiningNumbers(inputLottoNumbers);
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return getWinningNumbersFromInput();
        }
    }

    private BonusNumber getBonusNumberFromInput() {
        try {
            String inputBonusNumber = inputView.requestLottoBonusNumber();
            return Parser.parseLottoBonusNumber(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e);
            return getBonusNumberFromInput();
        }
    }

    private TicketCount getTicketCount(PurchaseAmount purchaseAmount) {
        return TicketCount.create(purchaseAmount);
    }

    private Lottos createLottos(TicketCount ticketCount) {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        LottosGenerator lottosGenerator = LottosGenerator.create(lottoNumbersGenerator);
        return Lottos.create(ticketCount, lottosGenerator);
    }
}
