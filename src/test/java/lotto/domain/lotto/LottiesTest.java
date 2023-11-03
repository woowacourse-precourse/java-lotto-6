package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.dto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottiesTest {

    @DisplayName("Lotties 에 Lotto 를 추가한 후 LottoDto 를 만들면 추가한 Lotto 가 LottoDto 안에 들어있다.")
    @Test
    void lottiesTest_1() {
        // Given
        Lotties lotties = new Lotties();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // When
        lotties.addLotto(lotto);
        LottoDto lottoDto = lotties.makeLottoDto();
        // Then
        assertThat(lottoDto.getData()).contains(lotto);
    }
}
