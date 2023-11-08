package lotto.controller;

import lotto.domain.model.lotto.*;
import lotto.domain.model.result.WinningRankCounts;
import lotto.dto.LottoTicketsDto;
import lotto.dto.ProfitRateDto;
import lotto.dto.WinningRankCountsDto;
import lotto.service.LottoService;
import lotto.view.InputProcessor;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final InputProcessor inputProcessor;
    private final LottoService lottoService;

    public LottoController(final OutputView outputView, final InputView inputView, final InputProcessor inputProcessor, final LottoService lottoService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputProcessor = inputProcessor;
        this.lottoService = lottoService;
    }

    public void play() {

        PaidAmount paidAmount = requestPaidAmount();
        LottoTickets issuedLottoTickets = lottoService.issue(paidAmount);
        outputView.printIssuedLottoTickets(LottoTicketsDto.from(issuedLottoTickets));

        LottoWinningNumbers lottoWinningNumbers = requestLottoWinningNumbers();

        WinningRankCounts winningRankCounts = lottoService.collectWinningRanks(issuedLottoTickets, lottoWinningNumbers);
        outputView.printWinningCounts(WinningRankCountsDto.from(winningRankCounts));

        ProfitRateDto profitRateDto = lottoService.calculateProfitRate(winningRankCounts, paidAmount);
        outputView.printProfitRate(profitRateDto);
    }

    private PaidAmount requestPaidAmount() {
        while (true) {
            try {
                Integer paidAmountInput = inputProcessor.toPaidAmount(inputView.requestPaidAmount());
                outputView.printNewLine();
                return new PaidAmount(paidAmountInput);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private LottoWinningNumbers requestLottoWinningNumbers() {
        while (true) {
            try {
                Lotto winningNumber = requestWinningNumber();
                LottoNumber lottoNumber = requestBonusNumber();
                return new LottoWinningNumbers(winningNumber, lottoNumber);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private Lotto requestWinningNumber() {
        while (true) {
            try {
                List<Integer> winningNumbersInput = inputProcessor.toWinningNumbers(inputView.requestWinningNumbers());
                outputView.printNewLine();
                return Lotto.from(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private LottoNumber requestBonusNumber() {
        while (true) {
            try {
                Integer bonusNumberInput = inputProcessor.toBonusNumber(inputView.requestBonusNumber());
                outputView.printNewLine();
                return LottoNumber.from(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

}
