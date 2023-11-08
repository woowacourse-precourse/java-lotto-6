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

        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.register(purchaseAmount);

        double benefit = RateOfReturn.BENEFIT_ZERO_INITIAL_VALUE;
        benefit += purchasedLottoTickets.eachRankCount().get(Reward.FIRST_PLACE) * Reward.FIRST_PLACE.getReward();
        benefit += purchasedLottoTickets.eachRankCount().get(Reward.SECOND_PLACE) * Reward.SECOND_PLACE.getReward();
        benefit += purchasedLottoTickets.eachRankCount().get(Reward.THIRD_PLACE) * Reward.THIRD_PLACE.getReward();
        benefit += purchasedLottoTickets.eachRankCount().get(Reward.FOURTH_PLACE) * Reward.FOURTH_PLACE.getReward();
        benefit += purchasedLottoTickets.eachRankCount().get(Reward.FIFTH_PLACE) * Reward.FIFTH_PLACE.getReward();

        double result = benefit / (purchasedLottoTickets.allTicketCount() * PurchaseAmount.MIN_PURCHASE_LOTTO)
                * RateOfReturn.HUNDRED_TO_GET_PERCENTAGE;

        RateOfReturn rateOfReturn = new RateOfReturn(purchasedLottoTickets);
        rateOfReturn.initTicketResult();
        Assertions.assertThat(rateOfReturn.calculate()).isEqualTo(String.format("%.1f", result));
    }
}