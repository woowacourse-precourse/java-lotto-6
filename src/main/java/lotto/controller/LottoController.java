package lotto.controller;

import static lotto.view.constant.Message.NOTICE_PURCHASE_QUANTITY;

import java.util.Objects;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
    }
    public void run() {
        String inputMoney = inputView.requestPurchaseMoney();
        LottoTickets lottoTickets = LottoTickets.purchase(inputMoney);

        int lottoTicketQuantity = lottoTickets.getLottoTicketQuantity();
        outputView.printDynamicMessage(NOTICE_PURCHASE_QUANTITY, lottoTicketQuantity);

        outputView.printIterableMessage(lottoTickets.getLottoNumbers());

        String inputWinningNumber = inputView.requestWinningNumber();
        WinningNumber winningNumber = WinningNumber.create(inputWinningNumber);

        String inputBonusNumber = inputView.requestBonusNumber();
        winningNumber.createBonusNumber(inputBonusNumber);
    }
}
