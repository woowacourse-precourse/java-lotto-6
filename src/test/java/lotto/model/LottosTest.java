package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.mock.TestLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 개수만큼 로또 객체를 생성한다.")
    @Test
    void createLottos() {
        int numberOfLottos = 2;
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lottos lottos = Lottos.of(numberOfLottos, new TestLottoGenerator(validNumbers));

        assertThat(lottos).isNotNull();
        assertThat(lottos.toLottoDtos()).hasSize(numberOfLottos);
    }

    @DisplayName("로또 객체를 LottoDTO로 변환한다.")
    @Test
    void convertToLottoDTOs() {
        int numberOfLottos = 1;
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lottos lottos = Lottos.of(numberOfLottos, new TestLottoGenerator(validNumbers));

        List<LottoDTO> lottoDTOs = lottos.toLottoDtos();

        assertThat(lottoDTOs).hasSize(numberOfLottos);
        assertThat(lottoDTOs.get(0).numbers()).containsExactlyElementsOf(validNumbers);
    }


}