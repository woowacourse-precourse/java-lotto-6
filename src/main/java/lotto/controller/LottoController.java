package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;
import lotto.model.collections.LottoBundle;
import lotto.model.collections.LottoPurchaseAmount;
import lotto.model.collections.LottoTicketCount;
import lotto.service.LottoTicketService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoTicketService lottoTicketService;
    private final WinningNumberService winningNumberService;

    public LottoController(LottoTicketService lottoTicketService, WinningNumberService winningNumberService) {
        this.lottoTicketService = lottoTicketService;
        this.winningNumberService = winningNumberService;
    }

    public void run(){
        OutputView.printPurchaseAmountMessage();
        LottoPurchaseAmount purchaseAmount = lottoTicketService.parsePurchaseAmount(InputView.read());
        LottoTicketCount ticketCount = lottoTicketService.convertMoneyToTickets(purchaseAmount);
        OutputView.printTicketCountMessage(ticketCount.getCount());
        LottoBundle lottoBundle = lottoTicketService.generateLottoBundle(ticketCount.getCount());
        OutputView.printLottoBundle(lottoBundle);
        OutputView.printWinningNumbersMessage();
        WinningNumbers winningNumbers = winningNumberService.createWinningNumbers(InputView.read());
        OutputView.printBonusNumberMessage();
        BonusNumber bonusNumber = winningNumberService.createBonusNumber(InputView.read(),winningNumbers.getNumbers());
        System.out.println(bonusNumber.getNumber());
    }
}
