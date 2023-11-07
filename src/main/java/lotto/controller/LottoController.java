package lotto.controller;

import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.PurchaseAmountDto;
import lotto.dto.request.WinningNumbersDto;
import lotto.dto.response.LottoResultsDto;
import lotto.dto.response.LottoTicketsDto;
import lotto.model.LottoService;
import lotto.util.NumberGenerator;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final NumberGenerator numberGenerator;

    public LottoController(InputView inputView,
                           OutputView outputView,
                           LottoService lottoService,
                           NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        LottoTicketsDto lottoTicketsDto = purchaseLottoTickets();
        outputView.printTicketPurchasedCount(lottoTicketsDto);

        WinningNumbersDto winningNumbersDto = getWinningNumbersFromView();
        BonusNumberDto bonusNumberDto = getBonusNumberFromView(winningNumbersDto);

        LottoResultsDto lottoResultsDto = getLottoResults(lottoTicketsDto, winningNumbersDto, bonusNumberDto);
        printResultAndProfitRate(lottoResultsDto);
    }

    private LottoTicketsDto purchaseLottoTickets() {
        try {
            outputView.printEnterPurchaseAmount();
            PurchaseAmountDto purchaseAmountDto = inputView.readPurchaseAmount();
            return lottoService.purchaseLottos(numberGenerator, purchaseAmountDto);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return purchaseLottoTickets();
        }
    }

    private WinningNumbersDto getWinningNumbersFromView() {
        try {
            outputView.printEnterWinningNumbers();
            WinningNumbersDto winningNumbersDto = inputView.readWinningNumbers();
            Validator.validateWinningNumbers(winningNumbersDto);
            return winningNumbersDto;
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return getWinningNumbersFromView();
        }
    }

    private BonusNumberDto getBonusNumberFromView(WinningNumbersDto winningNumbersDto) {
        try {
            outputView.printEnterBonusNumber();
            BonusNumberDto bonusNumberDto = inputView.readBonusNumber();
            Validator.validateBonusNumber(winningNumbersDto, bonusNumberDto);
            return bonusNumberDto;
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return getBonusNumberFromView(winningNumbersDto);
        }
    }

    private LottoResultsDto getLottoResults(LottoTicketsDto lottoTicketsDto,
                                            WinningNumbersDto winningNumbersDto,
                                            BonusNumberDto bonusNumberDto) {
        try {
            return lottoService.calculateResults(lottoTicketsDto, winningNumbersDto, bonusNumberDto);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return getLottoResults(lottoTicketsDto, winningNumbersDto, bonusNumberDto);
        }
    }

    private void printResultAndProfitRate(LottoResultsDto lottoResultsDto) {
        outputView.printMatchResult(lottoResultsDto);
        outputView.printTotalProfitRate(lottoResultsDto);
    }
}
