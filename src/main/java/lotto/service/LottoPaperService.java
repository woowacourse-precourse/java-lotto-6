package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPaper;
import lotto.domain.payment.Payment;

import lotto.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoPaperService {
    public LottoPaper createLottoPaper(final Payment payment) {
        int ticketPurchaseCount = payment.ticketPurchaseCount();
        int payAmount = payment.amount();

        List<Lotto> lottoTickets = purchaseLottoWithTicketCount(ticketPurchaseCount);
        LottoPaper lottoPaper = new LottoPaper(payAmount, lottoTickets);

        return lottoPaper;
    }

    private List<Lotto> purchaseLottoWithTicketCount(int ticketPurchaseCount) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketPurchaseCount; i++) {
            lottoTickets.add(issueLottoTicket());
        }
        return lottoTickets;
    }

    private Lotto issueLottoTicket() {
        List<Integer> lottoNumbers = NumberGenerator.generateOrderedNumbers();
        return new Lotto(lottoNumbers);
    }
}
