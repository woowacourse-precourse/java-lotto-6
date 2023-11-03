package lotto.service;

import static lotto.constant.LottoInfo.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerServiceTest {

    private final PlayerService playerService = new PlayerService();

    @Test
    @DisplayName(value = "로또 복권의 금액이 1,000원일 때 구입 금액에 알맞은 수량의 로또 복권을 구입하는지 확인")
    void purchaseLottoBy10000Won() {
        long buyingPrice = 10000L;
        int quantity = (int) (buyingPrice / LOTTO_PRICE.getInfo());
        assertThat(playerService.purchaseLotto(buyingPrice).size()).isEqualTo(10);
    }

}