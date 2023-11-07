package lotto;

import lotto.Domain.PlayerNumber;
import lotto.Domain.PlayerPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerPriceTest {

    private PlayerPrice playerPrice;

    @BeforeEach
    public void setUp() {
        playerPrice = new PlayerPrice(10000);
    }

    @DisplayName("랜덤 넘버로 로또 번호 생성 및 개수의 반환이 잘 되는지 테스트한다.")
    @Test
    public void setUpLottoTicketsTest() {
        playerPrice.setUpLottoTickets(playerPrice.getBuyingPay());

        List<PlayerNumber> lottoTickets = playerPrice.getLottoTickets();
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.size()).isEqualTo(10);
    }

    @DisplayName("플레이어가 구입금액을 입력하여 로또 번호를 잘 발행하는지 테스트한다.")
    @Test
    public void getBuyingPayTest() {
        int result = playerPrice.getBuyingPay();

        assertThat(result).isEqualTo(10000);
    }

    @DisplayName("로또 당첨금을 잘 가져오는지 테스트한다.")
    @Test
    public void addWinningMoneyTest() {
        // When
        playerPrice.addWinningMoney(5000);

        // Then
        int winningMoney = playerPrice.getWinningMoney();
        assertThat(winningMoney).isEqualTo(5000);
    }
}

