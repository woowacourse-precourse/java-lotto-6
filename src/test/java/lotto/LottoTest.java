package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개를 넘지 못 하면 예외가 발생한다.")
    void createLottoByLessSize() {
        var lottoNumbers = List.of(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또 번호의 범위를 넘어가는 수가 있다면 예외가 발생한다.")
    void createLottoByOutOfLottoNumberRange() {
        var lottoNumbers = List.of(1, 2, 3, 4, 5, 46);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또 정상 생성")
    void createLotto() {
        var lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new Lotto(lottoNumbers));
    }
}