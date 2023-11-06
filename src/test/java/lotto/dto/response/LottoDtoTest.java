package lotto.dto.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import lotto.model.Lotto;

class LottoDtoTest {

    @Test
    void getSortedNumbers() {
        Lotto lotto = Lotto.from(List.of(6, 5, 4, 3, 2, 1));
        LottoDto lottoDto = LottoDto.from(lotto);

        List<Integer> sortedNumbers = lottoDto.getSortedNumbers();

        assertThat(sortedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
