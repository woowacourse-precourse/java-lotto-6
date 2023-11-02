package lotto;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @Test
    void 로또_한장_번호_생성() {
        List<Integer> lotto = LottoNumberGenerator.generateLottoNumber();

        assertThat(lotto)
                .hasSize(6)
                .allSatisfy(number -> assertThat(number).isBetween(1, 45));
    }

    @Test
    void 로또_여러장_생성() {
        int ticketNumber = 5;
        List<List<Integer>> lottos = LottoNumberGenerator.generateLottoNumbers(5);

        assertThat(lottos)
                .hasSize(5)
                .allSatisfy(lotto -> {
                    assertThat(lotto)
                            .hasSize(6)
                            .allSatisfy(number -> assertThat(number).isBetween(1, 45));
                });
    }
}