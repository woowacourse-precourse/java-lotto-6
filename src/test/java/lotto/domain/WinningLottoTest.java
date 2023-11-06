package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 보너스_번호와_당첨_번호가_중복될_경우_예외_발생() {
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호와 당첨 번호는 중복될 수 없습니다.");
    }

    @Test
    void 보너스_번호와_당첨_번호가_서로_다를_경우_예외_미발생() {
        assertThatNoException()
                .isThrownBy(() -> new WinningLotto(lottoNumbers, 7));
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 46})
    void 보너스_번호가_1부터_45사이가_아니라면_예외_발생(int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45사이의 숫자여야 합니다.");
    }
}