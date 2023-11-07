package lotto.view.output;

import lotto.model.LottoTicket;
import lotto.view.Prompt;

public class LottoTicketInfoOutputView extends OutputView {

    private final LottoTicket ticket;
    private final Prompt message = Prompt.FORMAT_NUMBER_OF_PLAYS;

    public LottoTicketInfoOutputView(LottoTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void render() {
        message.println(ticket.numberOfPlays());
        ticket.getLottoPlays()
                .stream()
                .map(LottoNumberOutputView::new)
                .forEach(OutputView::render);
    }
}
