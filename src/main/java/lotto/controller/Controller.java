package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;
import lotto.service.NumberMatchingService;
import lotto.service.EarningRateService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class Controller {
    LottoService lottoService;

    private static final String ERROR = "[ERROR] ";

    public Controller() {
        this.lottoService = new LottoService();
    }

    public void run() {
        lottoTicketSetting();
        showTicketCount();
        lottoGameSetting();
        WinningNumbers winningNumbers = winningNumberSetting();
        BonusNumber bonusNumber = bonusNumberSetting(winningNumbers);
        showSystemMessage();
        showWinningResults(winningNumbers, bonusNumber);
    }

    private void lottoTicketSetting() {
        while (true) {
            String moneyInput = InputView.inputMoney();
            try {
                lottoService.createLottoTicket(moneyInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    private void showTicketCount() {
        OutputView.displayTicket_Count(lottoService.getTicketCount());
    }

    private void lottoGameSetting() {
        List<Lotto> lottoNumber = lottoService.purchaseLottoTickets();
        OutputView.displayLottoNumber(lottoNumber);
    }

    private WinningNumbers winningNumberSetting() {
        while (true) {
            try {
                String[] winningNumbersInput = InputView.inputWinningNumber();
                return new WinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    private BonusNumber bonusNumberSetting(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String bonusNumberString = InputView.inputBonusNumber();
                return new BonusNumber(bonusNumberString, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    private void showSystemMessage() {
        OutputView.displaySystemMessage();
    }

    private void showWinningResults(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        NumberMatchingService numberMatchingService = new NumberMatchingService();
        EnumMap<LottoPrize, Integer> winCount = numberMatchingService.calculateResults(lottoService.getAllLottoNumbers(), winningNumbers.getWinningNumbers(), bonusNumber.getBonusNumber());

        OutputView.displayLottoResult(winCount);

        EarningRateService earningRateService = new EarningRateService();
        double earningsRate = earningRateService.calculateEarningsRate(winCount, lottoService.getTicketCount());
        OutputView.displayEarningsRate(earningsRate);
    }
}