package lotto.controller;

//*의 경우 해당 패키지 내 모든 클래스 참조

import lotto.repository.LottoRepository;
import lotto.validator.WinningNumbers;
import lotto.validator.BonusNumber;
import lotto.service.*;
import lotto.view.*;

public class Controller {
    private final LottoService lottoService;
    private final NumberMatchingService numberMatchingService;
    private final EarningRateService earningRateService;
    private final LottoRepository repository;
    private static final String ERROR = "[ERROR] ";

    public Controller() {
        this.lottoService = new LottoService();
        this.numberMatchingService = new NumberMatchingService();
        this.earningRateService = new EarningRateService();
        this.repository = new LottoRepository();
    }

    public void run() {
        lottoTicketSetting();
        showTicketCount();
        lottoNumberSetting();
        winningNumberSetting();
        bonusNumberSetting();
        showSystemMessage();
        lottoResultSetting();
        showWinningResults();
        showEarningRate();
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

    private void lottoNumberSetting() {
        this.repository.setLottos(lottoService.generateLottoNumbers());
        OutputView.displayLottoNumbers(this.repository.getLottos());
    }

    private void winningNumberSetting() {
        while (true) {
            try {
                String[] winningNumbersInput = InputView.inputWinningNumber();
                this.repository.setWinningNumbers(new WinningNumbers(winningNumbersInput));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    private void bonusNumberSetting() {
        while (true) {
            try {
                String bonusNumberInput = InputView.inputBonusNumber();
                this.repository.setBonusNumber
                        (new BonusNumber(bonusNumberInput, this.repository.getWinningNumbers()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    private void showSystemMessage() {
        OutputView.displaySystemMessage();
    }

    private void lottoResultSetting() {
        this.repository.setWinCount(numberMatchingService.calculateWinCounts(
                this.repository.getLottos(),
                this.repository.getWinningNumbers(),
                this.repository.getBonusNumber()));
    }

    private void showWinningResults() {
        OutputView.displayLottoResult(this.repository.getWinCount());
    }

    private void showEarningRate() {
        double earningsRate = earningRateService.calculateEarningsRate(
                this.repository.getWinCount(),
                lottoService.getTicketCount());
        OutputView.displayEarningsRate(earningsRate);
    }
}