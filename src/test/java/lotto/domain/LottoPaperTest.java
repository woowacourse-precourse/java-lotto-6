package lotto.domain;

import lotto.util.LottoNumberGenerator;
import lotto.util.LottoTicketCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoPaperTest {
    @Test
    @DisplayName("금액 과 로또 들을 통해 LottoPaper 을 만든다.")
    void purchaseLottoWithAmount(){
        Payment payment = new Payment(5000);
        int amount = payment.amount();
        List<Lotto> lottoTickets = new ArrayList<>();

        int lottoTicketSize = LottoTicketCalculator.calculateLottoTicketQuantityWithAmount(amount);
        for ( int i = 0 ; i < lottoTicketSize; i++ ) {
            lottoTickets.add(new Lotto(LottoNumberGenerator.generateOrderedLottoNumbers()));
        }
        LottoPaper lottoPaper = new LottoPaper(payment.amount(),lottoTickets);

        Assertions.assertEquals(LottoPaper.class,lottoPaper.getClass());
        Assertions.assertEquals(lottoTicketSize,lottoPaper.lottoTickets().size());
        Assertions.assertEquals(amount,lottoPaper.amount());
    }
}
