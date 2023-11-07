package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.constans.WinningRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientTest {
    private static final LottosResult lottosResult = LottosResult.create();

    @BeforeEach
    void setUp() {
        lottosResult.updateResult(WinningRank.FIFTH_PRIZE);
    }

    @DisplayName("당첨 결과가 주어졌을 때 수익률을 계산한다. - 7000원으로 5000원 당첨되면 71.4% 수익률")
    @Test
    void testCalculateRateOfReturnCaseOne() {
        Client client = Client.from("7000");

        double rateOfReturn = client.calculateRateOfReturn(lottosResult);

        assertThat(rateOfReturn).isEqualTo(71.4);
    }

    @DisplayName("당첨 결과가 주어졌을 때 수익률을 계산한다. - 13000원으로 5000원 당첨되면 38.5% 수익률")
    @Test
    void testCalculateRateOfReturnCaseTwo() {
        Client client = Client.from("13000");

        double rateOfReturn = client.calculateRateOfReturn(lottosResult);

        assertThat(rateOfReturn).isEqualTo(38.5);
    }
}
