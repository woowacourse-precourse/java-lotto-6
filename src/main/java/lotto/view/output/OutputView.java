package lotto.view.output;

import lotto.model.LottoTicket;

public abstract class OutputView {

    public static OutputView of(LottoTicket ticket) {
        return new LottoTicketInfoOutputView(ticket);
    }

    public abstract void render();
}
