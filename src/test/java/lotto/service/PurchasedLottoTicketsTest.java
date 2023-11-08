package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.readUserInput.PurchaseAmount;
import lotto.readUserInput.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class PurchasedLottoTicketsTest {

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    void 당첨정보확인() {
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        String money = "100000";
        System.setIn(new ByteArrayInputStream(money.getBytes()));
        purchaseAmount.read();
        Console.close();

        WinningNumbers winningNumbers = new WinningNumbers();
        String numbers = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(numbers.getBytes()));
        winningNumbers.read();

        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.register(purchaseAmount);
        int count = 0;
        for (Reward reward : Reward.values()) {
            count += purchasedLottoTickets.eachRankCount().get(reward);
        }

        Assertions.assertThat(count).isEqualTo(100);

    }
}