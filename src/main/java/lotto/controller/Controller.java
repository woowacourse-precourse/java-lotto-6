package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Lotto;

import java.util.List;
import java.util.Set;

public class Controller {
    InputView inputView;
    LottoService lottoService;

    int ticketCount;
    private static final String ERROR = "[ERROR] ";

    public Controller() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        lottoTicketSetting();
        showTicketCount();
        lottoGameSetting();
        WinningNumbers winningNumbers = winningNumberSetting();
        BonusNumber bonusNumber = bonusNumberSetting(winningNumbers);
    }

    private void lottoTicketSetting() {
        while (true) {
            String moneyInput = InputView.inputMoney();
            try {
                LottoTicket lottoTicket = new LottoTicket(moneyInput);
                this.ticketCount = lottoTicket.getTicketCount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    private void showTicketCount() {
        OutputView.displayTicket_Count(ticketCount);
    }

    private void lottoGameSetting() {
        List<Lotto> lottoNumber = lottoService.purchaseLottoTickets(ticketCount);
        OutputView.displayLottoNumber(lottoNumber);
    }

    private WinningNumbers winningNumberSetting() {
        while (true) {
            try {
                String[] winningNumbers = InputView.inputWinningNumber();
                return new WinningNumbers(winningNumbers);
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
                // 유효하지 않은 입력에 대한 처리
            }
        }
    }
}
