package lotto.domain;

import java.util.List;

public class AutoCreatedLottoGame implements LottoGame {

    private final TicketDispenser<Lotto> ticketDispenser;

    public AutoCreatedLottoGame(TicketDispenser<Lotto> ticketDispenser) {
        this.ticketDispenser = ticketDispenser;
    }

    @Override
    public PurchasedLottoTickets purchaseLottoTickets(String cost) {
        int paymentCost = convertStringCostToInt(cost);
        List<Lotto> purchasedLotto = ticketDispenser.buyAutoCreatedTicket(paymentCost);
        return new PurchasedLottoTickets(purchasedLotto);
    }

    private int convertStringCostToInt(String cost) {
        try {
            return Integer.parseInt(cost);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("유효하지 않은 금액입니다.");
        }
    }

    @Override
    public Lotto createWinningLotto(List<Integer> numbers) {
        return ticketDispenser.createWinningTicket(() -> numbers);
    }

    @Override
    public PurchasedLottoStatistics createStatistics(
            PurchasedLottoTickets purchasedLottoTickets,
            Lotto winningLotto,
            int bonusNumber
    ) {
        return purchasedLottoTickets.collectStatistics(winningLotto, bonusNumber);
    }

}
