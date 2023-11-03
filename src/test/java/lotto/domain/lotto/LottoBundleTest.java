package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.dto.LottoBundleDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {

    @DisplayName("LottoBundle 에 Lotto 를 추가한 후 LottoDto 를 만들면 추가한 Lotto 가 LottoDto 안에 들어있다.")
    @Test
    void lottoBundleTest_1() {
        // Given
        LottoBundle lottoBundle = new LottoBundle();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // When
        lottoBundle.addLotto(lotto);
        LottoBundleDto lottoBundleDto = lottoBundle.makeLottoDto();
        // Then
        assertThat(lottoBundleDto.getLottoBundle()).contains(lotto);
    }
}
