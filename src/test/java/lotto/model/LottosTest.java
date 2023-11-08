package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("사용자가 구매한 개수만큼 로또를 생성하는가?")
    @Test
    void lottos_특정횟수만큼_로또_생성() {
        int count = 3;
        Lottos lottos = new Lottos(count);
        assertThat(lottos.getLottos().size()).isEqualTo(count);
    }
}
