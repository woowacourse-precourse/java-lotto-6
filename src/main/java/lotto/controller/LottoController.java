package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoPaper;
import lotto.domain.Payment;
import lotto.util.LottoNumberGenerator;
import lotto.util.LottoTicketCalculator;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public LottoPaper purchaseLottoWithPayment(Payment payment){
        int amount = payment.amount();
        int lottoTicketSize = LottoTicketCalculator.calculateLottoTicketQuantityWithAmount(amount);
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoTicketSize; i++) {
            lottoTickets.add(issueLottoTicket());
        }
        return new LottoPaper(amount,lottoTickets);
    }
    private Lotto issueLottoTicket(){
        List<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
        return new Lotto(lottoNumbers);
    }
}
