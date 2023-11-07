package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPaper;
import lotto.domain.payment.Payment;
import lotto.util.LottoNumberGenerator;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoPaperController {
    public LottoPaper createLottoPaperWithPayment(Payment payment){
        int amount = payment.ticketPurchaseCount();

        List<Lotto> lottoTickets = purchaseLottoWithAmount(amount);
        LottoPaper lottoPaper = new LottoPaper(amount,lottoTickets);
        OutputView.printLottoPaperMessage(lottoPaper);

        return lottoPaper;
    }
    private List<Lotto> purchaseLottoWithAmount(int ticketPurchaseCount){
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketPurchaseCount; i++) {
            lottoTickets.add(issueLottoTicket());
        }
        return lottoTickets;
    }
    private Lotto issueLottoTicket(){
        List<Integer> lottoNumbers = LottoNumberGenerator.generateOrderedLottoNumbers();
        return new Lotto(lottoNumbers);
    }
}
