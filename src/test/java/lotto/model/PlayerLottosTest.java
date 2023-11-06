package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PlayerLottosTest {

    @Test
    void 사용자_로또_수량에_맞게_발급_성공_테스트() {
        int lottoAmount = 4;

        PlayerLottos playerLottos = new PlayerLottos(lottoAmount);

        assertThat(playerLottos.getLottos().size()).isEqualTo(lottoAmount);
    }
}