package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerLottosTest {

    @DisplayName("구입한 로또 개수만큼 Lotto 객체를 생성한다.")
    @Test
    void 사용자_로또_수량에_맞게_발급_성공_테스트() {
        int lottoAmount = 4;

        PlayerLottos playerLottos = new PlayerLottos(lottoAmount);
        List<Lotto> lottos = playerLottos.getLottos();

        assertThat(lottos.size()).isEqualTo(lottoAmount);
    }
}