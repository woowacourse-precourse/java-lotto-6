package lotto.controller;

import lotto.dto.request.BonusNumberInputDto;
import lotto.dto.request.PurchaseAmountDto;
import lotto.dto.request.WinningNumbersDto;
import lotto.dto.request.WinningNumbersInputDto;
import lotto.dto.response.LottoResultsDto;
import lotto.dto.response.LottoTicketsDto;
import lotto.model.LottoMachine;
import lotto.model.LottoService;
import lotto.util.NumberGenerator;
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
        try {
            PurchaseAmountDto purchaseAmountDto = createMoney();
            LottoMachine lottoMachine = lottoService.createLottoMachine(numberGenerator, purchaseAmountDto);
            LottoTicketsDto lottoTicketsDto = lottoMachine.createLottoTickets();
            outputView.printTicketPurchasedCount(lottoTicketsDto);

            WinningNumbersDto winningNumbersDto = inputView.readWinningNumbers();
            LottoResultsDto results = lottoService.calculateResults(lottoTicketsDto, winningNumbersDto, money);
            outputView.printMatchResult(results);
            outputView.printTotalProfitRate(results);
        } catch (IllegalArgumentException e) {
            run();
        }
    }

    private PurchaseAmountDto createMoney() {
        outputView.printEnterPurchaseAmount();
        PurchaseAmountDto purchaseAmount = inputView.readPurchaseAmount();
        return purchaseAmount;
    }

    }
}
