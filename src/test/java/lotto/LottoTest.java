package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        @DisplayName("성공: 로또 번호에 주어진 숫자가 포함되어 있는지 불리언 값을 반환한다.")
        @Test
        void call_hasNumber_will_return_true() {
                //given
                Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

                //when
                boolean result = lotto.hasNumber(3);

                //then
                assertThat(result).isTrue();
        }

        @DisplayName("성공: 주어진 로또 번호와 몇개의 번호가 일치 하는지 반환한다.")
        @Test
        void call_matchCount_will_return_true() {
                //given
                Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                Lotto target = new Lotto(List.of(12, 2, 13, 4, 15, 6));

                //when
                long result = lotto.countMatchNumber(target);

                //then
                assertThat(result).isEqualTo(3);
        }
}
