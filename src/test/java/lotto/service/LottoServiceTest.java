package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("LottoService - 정상 입력")
    void normalLottoInput() {
        String numbers = "1,2,3,4,5,6";
        Lotto lotto = lottoService.createLotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("LottoService - 정수가 아닌 입력 포함")
    void containNonDecimal() {
        String numbers = "1,2,3,4,5,a";
        assertThatThrownBy(() -> lottoService.createLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("LottoService - 6개를 초과하는 입력")
    void moreThanSix() {
        String numbers = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> lottoService.createLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("LottoService - 범위에 맞지 않는 입력 포함")
    void containNumberOutOfRange() {
        String numbers = "1,2,63,4,5,6";
        assertThatThrownBy(() -> lottoService.createLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
