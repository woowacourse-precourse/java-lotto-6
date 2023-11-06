package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    void correctGenerateNumberOfLottos() {
        int expectedNumberOfLottos = 5;

        int actualNumberOfLottos = lottoService.generateLottos(expectedNumberOfLottos)
                                        .getLottos()
                                        .size();

        assertThat(actualNumberOfLottos).isEqualTo(expectedNumberOfLottos);
    }

    @Test
    void generatedLottoHasUniqueNumber() {
        int lottoCount = 5;
        Lottos generatedLottos = lottoService.generateLottos(lottoCount);

        for (Lotto lotto : generatedLottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(new HashSet<>(numbers).size());
        }
    }
}
