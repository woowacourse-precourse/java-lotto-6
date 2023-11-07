package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPaper;
import lotto.domain.payment.Payment;
import lotto.util.LottoNumberGenerator;
import lotto.util.LottoTicketCalculator;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoPaperController {
    public LottoPaper createLottoPaperWithPayment(Payment payment){
        int amount = payment.amount();

        List<Lotto> lottoTickets = purchaseLottoWithAmount(amount);
        LottoPaper lottoPaper = new LottoPaper(amount,lottoTickets);
        OutputView.printLottoPaperMessage(lottoPaper);

        return lottoPaper;
    }
    private List<Lotto> purchaseLottoWithAmount(int amount){
        int lottoTicketSize = LottoTicketCalculator.calculateLottoTicketQuantityWithAmount(amount);
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoTicketSize; i++) {
            lottoTickets.add(issueLottoTicket());
        }
        return lottoTickets;
    }
    private Lotto issueLottoTicket(){
        List<Integer> lottoNumbers = LottoNumberGenerator.generateOrderedLottoNumbers();
        return new Lotto(lottoNumbers);
    }
}
