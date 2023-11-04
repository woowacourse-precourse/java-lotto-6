
package lotto;

import lotto.domain.LottoTicket;
import lotto.service.LottoMachine;
import lotto.ui.InputView;
import lotto.ui.OutputMessage;
import lotto.ui.OutputView;

public class GameController {
    private final int TICKET_PRICE = 1000;
    private final InputView inputView;
    private final OutputView outputView;
    private LottoTicket lottoTicket;
    private int ticketCount;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoTicket = new LottoTicket();
    }

    public void play() {
        int amount = setAmount();
        ticketCount = amount / TICKET_PRICE;
        setLottoTicket();
        outputView.displayLottoTicket(OutputMessage.DISPLAY_TICKET_COUNT, ticketCount, lottoTicket);
    }

    private int setAmount() {
        outputView.displayMessage(OutputMessage.GET_AMOUNT_MESSAGE);
        int amount = inputView.getAmount();
        return amount;
    }

    private void setLottoTicket() {
        lottoTicket = LottoMachine.createLottoTicket(ticketCount);
    }
}