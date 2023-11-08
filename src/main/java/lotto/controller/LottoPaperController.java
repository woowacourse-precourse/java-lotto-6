package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPaper;
import lotto.domain.payment.Payment;

import lotto.util.NumberGenerator;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoPaperController {
    public LottoPaper createLottoPaperWithPayment(final Payment payment) {
        int ticketPurchaseCount = payment.ticketPurchaseCount();
        int payAmount = payment.amount();

        List<Lotto> lottoTickets = purchaseLottoWithTicketCount(ticketPurchaseCount);
        LottoPaper lottoPaper = new LottoPaper(payAmount, lottoTickets);
        OutputView.printLottoPaperMessage(lottoPaper);

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
