package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("로또 개수를 받아서 로또를 만들어준다.")
    @Test
    void generateLottos() {
        //given
        int numberOfLottos = 2;

        //when
        List<Lotto> lottos = lottoGenerator.generateLottos(numberOfLottos);

        //then
        assertThat(lottos.size()).isEqualTo(2);
    }
}