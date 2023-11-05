package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    LottoGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new LottoGenerator();
    }

    @Test
    @DisplayName("지정한 개수 만큼 로또 번호 생성")
    void makeLottos() {
        //given
        int numberOfLotto = 3;

        //when
        generator.makeLottos(numberOfLotto);

        //then
        assertThat(generator.getLottos().size()).isEqualTo(numberOfLotto);
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = generator.getLottos().get(i);
            assertThat(lotto).isInstanceOf(Lotto.class);
            assertThat(lotto.getNumbers()).isSorted();
        }
    }
}