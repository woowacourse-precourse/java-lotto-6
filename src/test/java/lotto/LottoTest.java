package lotto;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Nested
    @DisplayName("[Lotto] 기능 테스트")
    class LottoUnitTest {

        @Test
        @DisplayName("발행된 로또 번호 출력 확인")
        void toString_발행된_로또_번호_출력_확인() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            assertThat(lotto.toString())
                    .isEqualTo("[1, 2, 3, 4, 5, 6]");
        }

        @Test
        @DisplayName("로또 번호와 당첨 번호를 비교하여 일치하는 번호의 개수 확인")
        void isEqual_로또_번호와_당첨_번호를_비교하여_일치하는_번호의_개수_확인() {
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = List.of(1, 2, 4, 7, 8, 9);

            Lotto lotto = new Lotto(lottoNumbers);

            assertThat(lotto.checkWinningNumberCount(winningNumbers))
                    .isEqualTo(3);
        }
    }
}