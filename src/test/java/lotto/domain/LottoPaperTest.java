package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPaper;
import lotto.domain.payment.Payment;
import lotto.util.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoPaperTest {
    @Test
    @DisplayName("금액 과 로또 들을 통해 LottoPaper 을 만든다.")
    void purchaseLottoWithAmount() {
        Payment payment = Payment.of(5000);
        var amount = payment.amount();
        var ticketPurchaseCount = payment.ticketPurchaseCount();
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketPurchaseCount; i++) {
            lottoTickets.add(new Lotto(NumberGenerator.generateOrderedNumbers()));
        }
        LottoPaper lottoPaper = new LottoPaper(payment.amount(), lottoTickets);

        Assertions.assertEquals(LottoPaper.class, lottoPaper.getClass());
        Assertions.assertEquals(ticketPurchaseCount, lottoPaper.lottoTickets().size());
        Assertions.assertEquals(amount, lottoPaper.amount());
    }
}
