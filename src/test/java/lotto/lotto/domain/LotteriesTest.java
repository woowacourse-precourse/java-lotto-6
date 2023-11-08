package lotto.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.lottoPurchase.domain.LottoPurchase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteriesTest {

    private Integer purchaseAmount;

    @BeforeEach
    public void InsultMoneyEach() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        String input = "6000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        lottoPurchase.insult();
        lottoPurchase.calculate();
        this.purchaseAmount = lottoPurchase.getPurchaseAmount();

        Console.close();
    }

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @DisplayName("로또 구매 개수에 따른 로또를 발행한다.")
    @Test
    void 구매_금액에_따른_실물_로또_발행() {
        Lotteries lotteries = new Lotteries();

        lotteries.publishLotteries(purchaseAmount);

        assertThat(lotteries.getPublishedLotteryAmount()).isEqualTo(purchaseAmount);
    }

    @DisplayName("로또 구매 개수에 따른 로또를 발행하고 출력한다.")
    @Test
    void 발행한_모든_로또_출력() {
        Lotteries lotteries = new Lotteries();

        lotteries.publishLotteries(purchaseAmount);
        lotteries.printAllLotteries();

    }

}
