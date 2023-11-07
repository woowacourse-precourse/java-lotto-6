package lotto.controller;

//*의 경우 해당 패키지 내 모든 클래스 참조

import lotto.model.*;
import lotto.service.*;
import lotto.view.*;

import java.util.EnumMap;
import java.util.List;

public class Controller {
    private final LottoService lottoService;
    private final NumberMatchingService numberMatchingService;
    private final EarningRateService earningRateService;
    private List<Lotto> lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private EnumMap<LottoPrize, Integer> winCount;
    private static final String ERROR = "[ERROR] ";

    public Controller() {
        this.lottoService = new LottoService();
        this.numberMatchingService = new NumberMatchingService();
        this.earningRateService = new EarningRateService();
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
        this.lottos = lottoService.generateLottoNumbers();
        OutputView.displayLottoNumbers(lottos);
    }

    private void winningNumberSetting() {
        while (true) {
            try {
                String[] winningNumbersInput = InputView.inputWinningNumber();
                this.winningNumbers = new WinningNumbers(winningNumbersInput);
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
                this.bonusNumber = new BonusNumber(bonusNumberInput, winningNumbers);
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
        this.winCount = numberMatchingService.calculateWinCounts(this.lottos,
                winningNumbers,
                bonusNumber);
    }

    private void showWinningResults() {
        OutputView.displayLottoResult(winCount);
    }

    private void showEarningRate() {
        double earningsRate = earningRateService.calculateEarningsRate(winCount, lottoService.getTicketCount());
        OutputView.displayEarningsRate(earningsRate);
    }
}