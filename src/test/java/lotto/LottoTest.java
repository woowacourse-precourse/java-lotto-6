package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("로또 한 장 테스트")
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

    // 아래에 추가 테스트 작성 가능
    private static final List<Integer> SUCCESSFUL_LOTTO_NUMBERS = List.of(1, 8, 12, 15, 23, 36);

    @DisplayName("정상 작동")
    @Test
    void success() {
        Lotto lotto = new Lotto(SUCCESSFUL_LOTTO_NUMBERS);
        assertThat(lotto.toString()).isEqualTo(SUCCESSFUL_LOTTO_NUMBERS.toString());
    }

    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {
        private final List<Integer> LESS_SIZE_LOTTO_NUMBER = List.of(1, 2, 3, 4, 5);
        private final List<Integer> EXCEED_SIZE_LOTTO_NUMBER = List.of(1, 2, 3, 4, 5);
        private final List<Integer> DUPLICATION_LOTTO_NUMBER = List.of(1, 2, 3, 3, 6, 10);

        @DisplayName("로또 번호 개수가 6개 미만일 때 예외 테스트")
        @Test
        void lessSizeExceptionTest() {
            assertThatThrownBy(() -> new Lotto(LESS_SIZE_LOTTO_NUMBER))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호 개수가 6개 초과일 때 예외 테스트")
        @Test
        void exceedSizeExceptionTest() {
            assertThatThrownBy(() -> new Lotto(EXCEED_SIZE_LOTTO_NUMBER))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void duplicationExceptionTest() {
            assertThatThrownBy(() -> new Lotto(DUPLICATION_LOTTO_NUMBER))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}