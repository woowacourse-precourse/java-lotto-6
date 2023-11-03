package lotto;

import domain.Lotto;
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
    @DisplayName("로또 번호 개수 6개 미만 테스트")
    void createLottoLessSizeFailTest() {
        var lottoNumbers = List.of(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또 번호 중 생성할 수 없는 개수 포함 테스트")
    void createLottoOutOfLottoNumberRangeTest() {
        var lottoNumbers = List.of(1, 2, 3, 4, 5, 46);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또 생성 테스트")
    void createLottoSuccessTest() {
        var lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new Lotto(lottoNumbers));
    }
}