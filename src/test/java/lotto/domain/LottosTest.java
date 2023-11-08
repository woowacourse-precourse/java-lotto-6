package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("from 정상 작동 테스트")
    @Test
    void from_EqualResult_Success() {

        //given
        Lottos lottos;

        //when
        lottos = Lottos.from(5000);

        //then
        assertThat(lottos).isNotNull();
        assertThat(lottos.getLottos()).isNotNull();
        assertThat(lottos.getLottos().size()).isEqualTo(5);

    }



}
