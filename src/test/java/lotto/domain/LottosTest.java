package lotto.domain;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("로또 보관소에 로또 추가가 잘 되는지 확인한다.")
    @Test
    public void addNewLottoTest() throws Exception {
        // given
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        // when
        lottos.addNewLotto(lotto);

        // then
        assertThat(lottos.getLottos().get(0)).isEqualTo(lotto);
    }



}
