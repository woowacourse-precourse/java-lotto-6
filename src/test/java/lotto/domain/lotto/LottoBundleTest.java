package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.dto.LottoBundleDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {
    private LottoBundle lottoBundle;
    private Lotto lotto;

    @BeforeEach
    void initGivenCondition() {
        lottoBundle = new LottoBundle();
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("LottoBundle 에 Lotto 를 추가한 후 LottoDto 를 만들면 추가한 Lotto 가 LottoDto 안에 들어있다.")
    @Test
    void lottoBundleTest_1() {
        // When
        lottoBundle.addLotto(lotto);
        LottoBundleDto lottoBundleDto = lottoBundle.makeLottoBundleDto();
        // Then
        assertThat(lottoBundleDto.getLottoBundleData()).contains(lotto);
    }
}
