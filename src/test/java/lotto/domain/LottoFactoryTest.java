package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoFactoryTest {
    @DisplayName("생성할 로또 갯수를 입력받아 로또 리스트를 생성한다.")
    @Test
    void createLottos(){
        assertThat(LottoFactory.createLottos(6).size()).isEqualTo(6);
    }
}