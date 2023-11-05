package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientTest {
    @DisplayName("당첨 결과가 주어졌을 때 수익률을 계산한다. - 7000원으로 5000원 당첨되면 71.4% 수익률")
    @Test
    void testCalculateRateOfReturnCaseOne() {
        Client client = Client.from("7000");
        List<Integer> lottoResults = List.of(0, 0, 0, 0, 0, 1);

        double rateOfReturn = client.calculateRateOfReturn(lottoResults);

        assertThat(rateOfReturn).isEqualTo(71.4);
    }

    @DisplayName("당첨 결과가 주어졌을 때 수익률을 계산한다. - 13000원으로 55000원 당첨되면 71.4% 수익률")
    @Test
    void testCalculateRateOfReturnCaseTwo() {
        Client client = Client.from("13000");
        List<Integer> lottoResults = List.of(0, 0, 0, 0, 1, 1);

        double rateOfReturn = client.calculateRateOfReturn(lottoResults);

        assertThat(rateOfReturn).isEqualTo(423.1);
    }
}
