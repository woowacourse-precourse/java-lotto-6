package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {


    @DisplayName("로또 개수만큼 로또를 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 8})
    void createLottos(int lottoCount) {
        assertThat(LottoGenerator.createLottos(lottoCount).size()).isEqualTo(lottoCount);
    }

    @DisplayName("당첨 번호를 입력 받아 당첨 로또 생성")
    @Test
    void createWinningLotto() {

        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        assertThat(LottoGenerator.createWinningLotto("1,2,3,4,5,6").getNumbers()).isEqualTo(lotto.getNumbers());

    }



    }