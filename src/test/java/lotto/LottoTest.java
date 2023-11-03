package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @Nested
    @DisplayName("validateLottoSize 메소드 test")
    class ValidateLottoSize {
        @DisplayName("숫자 개수가 " + Lotto.LOTTO_SIZE + "와 일치하면 검증 통과")
        @Test
        void Match_lotto_size() {
            // given
            List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> numbers2 = List.of(10, 20, 30, 40, 44, 45);

            // when
            // then
            Lotto lotto1 = new Lotto(numbers1);
            Lotto lotto2 = new Lotto(numbers2);
        }

        @DisplayName("숫자 개수가 " + Lotto.LOTTO_SIZE + "와 일치하지 않으면 예외 발생")
        @Test
        void Unmatch_lotto_size() {
            // given
            List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
            List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7);

            // when
            // then
            assertThatThrownBy(() -> new Lotto(numbers1)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Lotto.INVALID_LOTTO_SIZE_MESSAGE);
            assertThatThrownBy(() -> new Lotto(numbers2)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Lotto.INVALID_LOTTO_SIZE_MESSAGE);
        }
    }
}