package lotto.domain;

public class TicketSeller {
    private final LottoGenerator lottoGenerator;

    public TicketSeller(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Ticket createTicket() {
        return new Ticket(lottoGenerator.generate());
    }
}
