package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lotto.model.constans.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientTest {
    @DisplayName("클라이언트가 가지고 있는 지불 금액을 확인할 수 있다.")
    @Test
    void testGetPayAmount() {
        Client client = Client.from("10000");

        int payAmount = client.getPayAmount();

        assertThat(payAmount).isEqualTo(10000);
    }

    @DisplayName("클라이언트에게 로또를 추가할 수 있다.")
    @Test
    void testAddLotto() {
        Client client = Client.from("10000");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        client.receiveLotto(lotto);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        assertThat(client.getLottos()).isEqualTo(lottos);
    }

    @DisplayName("당첨 결과가 주어졌을 때 수익률을 계산한다. - 7000원으로 5000원 당첨되면 71.4% 수익률")
    @Test
    void testCalculateRateOfReturnCaseOne() {
        Client client = Client.from("7000");
        LottosResult lottosResult = LottosResult.create();
        lottosResult.updateResult(WinningRank.FIFTH_PRIZE);

        double rateOfReturn = client.calculateRateOfReturn(lottosResult);

        assertThat(rateOfReturn).isEqualTo(71.4);
    }

    @DisplayName("당첨 결과가 주어졌을 때 수익률을 계산한다. - 13000원으로 5000원 당첨되면 38.5% 수익률")
    @Test
    void testCalculateRateOfReturnCaseTwo() {
        Client client = Client.from("13000");
        LottosResult lottosResult = LottosResult.create();
        lottosResult.updateResult(WinningRank.FIFTH_PRIZE);

        double rateOfReturn = client.calculateRateOfReturn(lottosResult);

        assertThat(rateOfReturn).isEqualTo(38.5);
    }
}
