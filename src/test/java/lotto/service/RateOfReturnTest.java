package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.readUserInput.PurchaseAmount;
import lotto.readUserInput.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RateOfReturnTest {

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    void 총수익률검증() {
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        String money = "100000";
        System.setIn(new ByteArrayInputStream(money.getBytes()));
        purchaseAmount.read();
        Console.close();

        WinningNumbers winningNumbers = new WinningNumbers();
        String numbers = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(numbers.getBytes()));
        winningNumbers.read();

        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets(purchaseAmount);

        double benefit = 0;
        benefit += purchasedLottoTickets.eachRankCount().get("1st") * 2000000000;
        benefit += purchasedLottoTickets.eachRankCount().get("2nd") * 30000000;
        benefit += purchasedLottoTickets.eachRankCount().get("3rd") * 1500000;
        benefit += purchasedLottoTickets.eachRankCount().get("4th") * 50000;
        benefit += purchasedLottoTickets.eachRankCount().get("5th") * 5000;

        double result = benefit / (purchasedLottoTickets.allTicketCount() * 1000) * 100;

        RateOfReturn rateOfReturn = new RateOfReturn(purchasedLottoTickets);
        Assertions.assertThat(rateOfReturn.calculate()).isEqualTo(String.format("%.1f", result));
    }
}