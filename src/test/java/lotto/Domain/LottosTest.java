package lotto.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("Lottos 객체생성 개수 테스트")
    public void createLottosTest() {
        int lottoCount = 5;
        Lottos lottos = new Lottos(lottoCount);

        assertThat(lottos.getSize()).isEqualTo(lottoCount);
    }
}
